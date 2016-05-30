package xyz.wit543.wit.tumboon.model;

/**
 * Created by Asus on 5/26/2016.
 */
public class Upgrade {

    private String layerName;
    private double multiplier;
    private boolean bought;
    private double price;
    private String upName;


    public Upgrade(String name ,String upName, double multiplier , boolean bought,double price){
        this.layerName = name;
        this.multiplier = multiplier;
        this.bought = bought;
        this.price = price;
        this.upName = upName;
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

    public boolean isBought() {
        return bought;
    }

    public void setBought(boolean bought) {
        this.bought = bought;
    }

    public double getprice() {return price;}

    public void upPrice(){
        for (LayerManager layerManager :Game.getInstance().getLayerManagers() ){
            if(layerManager.getLayer().getName().equalsIgnoreCase(this.getName())) {
                this.multiplier += 10;
                layerManager.setUpgrade(this.getMultiplier());
                this.price *= 2;
            }
        }
    }
}
