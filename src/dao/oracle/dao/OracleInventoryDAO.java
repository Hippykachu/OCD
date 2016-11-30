package dao.oracle.dao;

import dao.interfaces.InventoryDAO;
import dao.entities.Entity;
import dao.entities.Item;
import dao.oracle.OracleDAOFactory;
import view.controllers.LayoutController;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hugoc on 28/11/2016.
 */

public class OracleInventoryDAO implements InventoryDAO{
    private Connection con;

    public OracleInventoryDAO() {
        this.con = OracleDAOFactory.getConnection();
    }

    @Override
    public List<Item> getEquipment(Entity entity) {
        return getInventory(entity.getEquipmentId());
    }

    @Override
    public List<Item> getInventory(Entity entity) {
        return getInventory(entity.getInventoryId());
    }

    @Override
    public boolean equipItem(Entity entity, int itemID) {
        return moveItem(entity.getInventoryId(), entity.getEquipmentId(), itemID);
    }

    @Override
    public boolean unequipItem(Entity entity, int itemID) {
        return moveItem(entity.getEquipmentId(), entity.getInventoryId(), itemID);
    }

    @Override
    public boolean dropItem(Entity entity, int itemID) {
        return moveItem(entity.getInventoryId(), 0, itemID);
    }

    private List<Item> getInventory(int inventoryID) {
        PreparedStatement stm = null;
        ResultSet rs = null;
        List<Item> results = new ArrayList<>();
        try {
            stm = con.prepareStatement("SELECT * FROM TABLE(getItemsFromInventory(?))");
            stm.setInt(1, inventoryID);
            rs = stm.executeQuery();
            while (rs.next()) {
                results.add(new Item(
                        rs.getInt("itemID"),
                        rs.getInt("typeID"),
                        rs.getString("itemName"),
                        rs.getString("typeName"),
                        rs.getDouble("price"),
                        rs.getDouble("roomsToEquip"),
                        rs.getInt("bonusHealth"),
                        rs.getInt("bonusDefense"),
                        rs.getInt("bonusAttack"),
                        rs.getInt("bonusCritical")
                ));
            }
        } catch (SQLException e) {
            LayoutController.printError(e.getMessage());
        } finally {
            OracleDAOFactory.closeResultSet(rs);
            OracleDAOFactory.closeStatement(stm);
        }
        return results;
    }

    @Override
    public boolean moveItem(int inventoryIDFrom, int inventoryIDTo, int itemID) {
        CallableStatement stm = null;
        try {
            stm = con.prepareCall("{call moveItem(?, ?, ?)}");
            stm.setInt(1, inventoryIDFrom);
            stm.setInt(2, inventoryIDTo);
            stm.setInt(3, itemID);
            stm.execute();
            return true;
        } catch (SQLException e) {
            LayoutController.printError(e.getMessage());
        } finally {
            OracleDAOFactory.closeStatement(stm);
        }
        return false;
    }
}