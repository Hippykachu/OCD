package game.dao.entities;

import javafx.beans.property.*;

/**
 * Created by hugoc on 28/11/2016.
 */

public class Item {
    private IntegerProperty itemID;
    private IntegerProperty typeID;
    private StringProperty itemName;
    private StringProperty typeName;
    private DoubleProperty price;
    private DoubleProperty roomsToEquip;
    private IntegerProperty bonusHealth;
    private IntegerProperty bonusDefense;
    private IntegerProperty bonusAttack;
    private IntegerProperty bonusCritical;

    public Item(int itemID, int typeID, String itemName, String typeName, double price, double roomsToEquip, int bonusHealth, int bonusDefense, int bonusAttack, int bonusCritical) {
        this.itemID = new SimpleIntegerProperty(itemID);
        this.typeID = new SimpleIntegerProperty(typeID);
        this.itemName = new SimpleStringProperty(itemName);
        this.typeName = new SimpleStringProperty(typeName);
        this.price = new SimpleDoubleProperty(price);
        this.roomsToEquip = new SimpleDoubleProperty(roomsToEquip);
        this.bonusHealth = new SimpleIntegerProperty(bonusHealth);
        this.bonusDefense = new SimpleIntegerProperty(bonusDefense);
        this.bonusAttack = new SimpleIntegerProperty(bonusAttack);
        this.bonusCritical = new SimpleIntegerProperty(bonusCritical);
    }

    public int getItemID() {
        return itemID.get();
    }

    public IntegerProperty itemIDProperty() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID.set(itemID);
    }

    public int getTypeID() {
        return typeID.get();
    }

    public IntegerProperty typeIDProperty() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID.set(typeID);
    }

    public String getItemName() {
        return itemName.get();
    }

    public StringProperty itemNameProperty() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName.set(itemName);
    }

    public String getTypeName() {
        return typeName.get();
    }

    public StringProperty typeNameProperty() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName.set(typeName);
    }

    public double getPrice() {
        return price.get();
    }

    public DoubleProperty priceProperty() {
        return price;
    }

    public void setPrice(double price) {
        this.price.set(price);
    }

    public double getRoomsToEquip() {
        return roomsToEquip.get();
    }

    public DoubleProperty roomsToEquipProperty() {
        return roomsToEquip;
    }

    public void setRoomsToEquip(double roomsToEquip) {
        this.roomsToEquip.set(roomsToEquip);
    }

    public int getBonusHealth() {
        return bonusHealth.get();
    }

    public IntegerProperty bonusHealthProperty() {
        return bonusHealth;
    }

    public void setBonusHealth(int bonusHealth) {
        this.bonusHealth.set(bonusHealth);
    }

    public int getBonusDefense() {
        return bonusDefense.get();
    }

    public IntegerProperty bonusDefenseProperty() {
        return bonusDefense;
    }

    public void setBonusDefense(int bonusDefense) {
        this.bonusDefense.set(bonusDefense);
    }

    public int getBonusAttack() {
        return bonusAttack.get();
    }

    public IntegerProperty bonusAttackProperty() {
        return bonusAttack;
    }

    public void setBonusAttack(int bonusAttack) {
        this.bonusAttack.set(bonusAttack);
    }

    public int getBonusCritical() {
        return bonusCritical.get();
    }

    public IntegerProperty bonusCriticalProperty() {
        return bonusCritical;
    }

    public void setBonusCritical(int bonusCritical) {
        this.bonusCritical.set(bonusCritical);
    }
}
