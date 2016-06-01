package xyz.wit543.wit.tumboon.model;

/**
 * Created by Asus on 5/26/2016.
 */
public class Upgrade {

    private String layerName;
    private double price;
    private String upName;

    private double multiplier;
    private int upgradeCount;


    public Upgrade(String name ,String upName,double price){
        this.layerName = name;
        this.price = price;
        this.upName = upName;
        this.multiplier = 0;
        this.upgradeCount = 0;
    }

    public String getUpName() {
        return upName;
    }

    public void setUpName(String upName) {
        this.upName = upName;
    }

    public String getName() {
        return layerName;
    }

    public void setName(String name) {
        this.layerName = name;
    }

    public double getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(double multiplier) {
        this.multiplier = multiplier;
    }

    public double getprice() {return price;}

    public String getLayerName() {
        return layerName;
    }

    public void setLayerName(String layerName) {
        this.layerName = layerName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getUpgradeCount() {
        return upgradeCount;
    }

    public void setUpgradeCount(int upgradeCount) {
        this.upgradeCount = upgradeCount;
    }

    public void upPrice(){
        for (LayerManager layerManager :Game.getInstance().getLayerManagers() ){
            if(layerManager.getLayer().getName().equalsIgnoreCase(this.getName())) {
                this.multiplier += 10;
                this.price *= 2;
                layerManager.setUpgrade(this.getMultiplier());
                upgradeCount++;
            }
        }
    }
}