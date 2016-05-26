package xyz.wit543.wit.tumboon.model;

/**
 * Created by WIT on 21-May-16.
 */
public class Layer implements Producible{
    private String name;
    private int level;
    private double baseOutcome;
    private int productionTime;

    public Layer(String name, int level, double baseOutcome, int productionTime) {
        this.name = name;
        this.level = level;
        this.baseOutcome = baseOutcome;
        this.productionTime = productionTime;
    }

    private Layer(Builder builder){
        this.name = builder.name;
        this.level = builder.level;
        this.baseOutcome = builder.baseOutcome;
        this.productionTime = builder.productionTime;
    }

    public int getProductionTime() {
        return productionTime;
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

    public class Memento {
        private String name;
        private int level;
        private double baseOutcome;
        private int productionTime;
        private long savedTime;
        private Memento(){
            this.name = Layer.this.name;
            this.level = Layer.this.level;
            this.baseOutcome = Layer.this.baseOutcome;
            this.productionTime = Layer.this.productionTime;
            this.savedTime = System.currentTimeMillis();
        }

        private void restore(){
            Layer.this.name = this.name;
            Layer.this.level = this.level;
            Layer.this.baseOutcome = this.baseOutcome;
            Layer.this.productionTime = this.productionTime;
        }

    }

    public static class Builder{
        private String name="default";
        private int level=0;
        private double baseOutcome=1;
        private int productionTime=3600;
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
        public Layer build(){
            return new Layer(this);
        }
    }
}