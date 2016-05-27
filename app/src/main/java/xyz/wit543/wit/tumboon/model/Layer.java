package xyz.wit543.wit.tumboon.model;

/**
 * Created by WIT on 21-May-16.
 */
public class Layer implements Producible{
    private String name;
    private int level;
    private double baseOutcome;
    private double basePrice;
    private int baseProductionTime;
    private double price;
    private double outcome;

    private final double speedIncreasePerSec = 5;


    public Layer(String name, int level,double basePrice, double baseOutcome, int baseProductionTime) {
        this.name = name;
        this.level = level;
        this.basePrice = basePrice;
        this.baseOutcome = baseOutcome;
        this.baseProductionTime = baseProductionTime;
    }

    private Layer(Builder builder){
        this.name = builder.name;
        this.level = builder.level;
        this.baseOutcome = builder.baseOutcome;
        this.baseProductionTime = builder.productionTime;
        this.basePrice = builder.basePrice;
        this.price = basePrice;
        this.outcome = baseOutcome;
    }

    public double getPrice() {
        return basePrice;
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

    public int getLevel() {
        return level;
    }

    public double getBaseOutcome() {
        return baseOutcome;
    }

    public void restore(Memento memento){
        memento.restore();
    }
    public Memento saveState(){
        return new Memento();
    }

    public double getOutcome(){
        return level *baseOutcome;
    }

    public void increaseLevel(){
        this.level++;
    }

    public double getProductionTime(){
        double netTime = this.getBaseProductionTime() - (this.getLevel()-1)*speedIncreasePerSec;
        if(netTime < 100){
            netTime = 100;
        }
        return netTime;
    }

    public class Memento {
        private String name;
        private int level;
        private double baseOutcome;
        private int productionTime;
        private double basePrice;
        private double price;
        private double outcome;
        private long savedTime;
        private Memento(){
            this.name = Layer.this.name;
            this.level = Layer.this.level;
            this.baseOutcome = Layer.this.baseOutcome;
            this.productionTime = Layer.this.baseProductionTime;
            this.baseOutcome = Layer.this.basePrice;
            this.basePrice = Layer.this.basePrice;
            this.price = Layer.this.price;
            this.outcome = Layer.this.outcome;
            this.savedTime = System.currentTimeMillis();
        }

        private void restore(){
            Layer.this.name = this.name;
            Layer.this.level = this.level;
            Layer.this.baseOutcome = this.baseOutcome;
            Layer.this.baseProductionTime = this.productionTime;
            Layer.this.baseOutcome = this.baseOutcome;
            Layer.this.basePrice = this.basePrice;
            Layer.this.price = this.price;
            Layer.this.outcome = this.outcome;
        }

    }

    public static class Builder{
        private String name="default";
        private int level=0;
        private double baseOutcome=1;
        private int productionTime=3600;
        private double basePrice=100;
        public Builder name(String name){
            this.name = name;
            return this;
        }
        public Builder level(int level){
            this.level = level;
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