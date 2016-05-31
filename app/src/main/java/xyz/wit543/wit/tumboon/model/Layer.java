package xyz.wit543.wit.tumboon.model;

import android.graphics.drawable.Drawable;

/**
 * Created by WIT on 21-May-16.
 */
public class Layer{
    private String name;
    private double baseOutcome;
    private double basePrice;
    private int baseProductionTime;
    private int layerPic;

    public Layer(String name,double basePrice, double baseOutcome, int baseProductionTime , int layerPic) {
        this.name = name;
        this.basePrice = basePrice;
        this.baseOutcome = baseOutcome;
        this.baseProductionTime = baseProductionTime;
        this.layerPic = layerPic;
    }

    private Layer(Builder builder){
        this.name = builder.name;
        this.baseOutcome = builder.baseOutcome;
        this.baseProductionTime = builder.productionTime;
        this.basePrice = builder.basePrice;
        this.layerPic = builder.layerPic;
    }

    public double getBasePrice(){
        return basePrice;
    }

    public int getBaseProductionTime() {
        return baseProductionTime;
    }

    public String getName() {
        return name;
    }

    public double getBaseOutcome() {
        return baseOutcome;
    }


    public int getLayerPic() {
        return layerPic;
    }

    public void setLayerPic(int layerPic) {
        this.layerPic = layerPic;
    }


    public void restore(Memento memento){
        memento.restore();
    }

    public Memento saveState(){
        return new Memento();
    }
//
//    public double getProductionTime(){
//        double netTime = this.getBaseProductionTime() - (this.getLevel()-1)*speedIncreasePerSec;
//        if(netTime < 100){
//            netTime = 100;
//        }
//        return netTime;
//    }

    public class Memento {
        private String name;
        private int level;
        private double baseOutcome;
        private int productionTime;
        private double basePrice;
        private long savedTime;
        private Memento(){
            this.name = Layer.this.name;
            this.baseOutcome = Layer.this.baseOutcome;
            this.productionTime = Layer.this.baseProductionTime;
            this.baseOutcome = Layer.this.basePrice;
            this.basePrice = Layer.this.basePrice;
            this.savedTime = System.currentTimeMillis();
        }

        private void restore(){
            Layer.this.name = this.name;
            Layer.this.baseOutcome = this.baseOutcome;
            Layer.this.baseProductionTime = this.productionTime;
            Layer.this.baseOutcome = this.baseOutcome;
            Layer.this.basePrice = this.basePrice;
        }

    }

    public static class Builder{
        private String name="default";
        private double baseOutcome=1;
        private int productionTime=3600;
        private double basePrice=100;
        private int layerPic;
        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder layerPic(int layerPic){
            this.layerPic = layerPic;
            return this;
        }
        public Builder baseOutcome(double baseOutcome){
            this.baseOutcome = baseOutcome;
            return this;
        }
        public Builder productionTime(int productionTime){
            this.productionTime = productionTime;
            return this;
        }
        public Builder basePrice(double basePrice){
            this.basePrice=basePrice;
            return this;
        }
        public Layer build(){
            return new Layer(this);
        }


    }
}