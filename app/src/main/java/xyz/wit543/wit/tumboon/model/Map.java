package xyz.wit543.wit.tumboon.model;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Momo on 26/5/2559.
 */
public class Map {
    private List<Layer> layers;
    private double productionRate;
    private double productionBonus;
    private double layerBuyRate;
    private String name;

    public Map(List<Layer> layers,double productionRate,double productionBonus,double layerBuyRate,String name){
        this.layers = layers;
        this.productionRate = productionRate;
        this.productionBonus = productionBonus;
        this.layerBuyRate = layerBuyRate;
        this.name = name;
    }

    public Map(Builder builder){
        this.layers = builder.layers;
        this.productionRate = builder.productionRate;
        this.productionBonus = builder.productionBonus;
        this.layerBuyRate = builder.layerBuyRate;
        this.name = builder.name;
    }

    public List<Layer> getLayers() {
        return layers;
    }
    public void setLayers(List<Layer> layers) {
        this.layers = layers;
    }
    public double getProductionRate() {
        return productionRate;
    }
    public void setProductionRate(double productionRate) {
        this.productionRate = productionRate;
    }
    public double getProductionBonus() {
        return productionBonus;
    }
    public void setProductionBonus(double productionBonus) {
        this.productionBonus = productionBonus;
    }
    public double getLayerBuyRate() {
        return layerBuyRate;
    }
    public void setLayerBuyRate(double layerBuyRate) {
        this.layerBuyRate = layerBuyRate;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Memento saveState(){
        return new Memento();
    }
    public void restore(Memento memento){
        memento.restore();
    }
    public Iterator getLayer(){
        return new MapIterator();
    }


    public class MapIterator implements Iterator{
        private int index;

        @Override
        public void remove() {
        }
        @Override
        public boolean hasNext() {
           if(index < layers.size()){
               return true;
           }
            return false;
        }
        @Override
        public Object next() {
            if(this.hasNext()){
                return layers.get(index);
            }
            return null;
        }
    }

    public static class Builder{
        private List<Layer> layers;
        private double productionRate;
        private double productionBonus;
        private double layerBuyRate;
        private String name;

        public Builder name(String name) {
            this.name = name;
            return this;
        }
        public Builder layers(List<Layer> layers){
            this.layers = layers;
            return this;
        }
        public Builder productionRate(double productionRate){
            this.productionRate = productionRate;
            return this;
        }
        public Builder productionBonus(double productionBonus){
            this.productionBonus = productionBonus;
            return this;
        }
        public Builder layerBuyRate(double layerBuyRate){
            this.layerBuyRate = layerBuyRate;
            return this;
        }
        public Map build(){
            return new Map(this);
        }
    }

    public class Memento{
        private List<Layer> layers;
        private double productionRate;
        private double productionBonus;
        private double layerBuyRate;
        private String name;

        public Memento(){
            this.name = Map.this.name;
            this.layers = Map.this.layers;
            this.productionRate = Map.this.productionRate;
            this.productionBonus = Map.this.productionBonus;
            this.layerBuyRate = Map.this.layerBuyRate;
        }
        public void restore(){
            Map.this.name = this.name;
            Map.this.layers = this.layers;
            Map.this.productionRate = this.productionRate;
            Map.this.productionBonus = this.productionBonus;
            Map.this.layerBuyRate = this.layerBuyRate;
        }
    }


}
