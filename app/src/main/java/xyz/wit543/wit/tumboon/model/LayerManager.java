package xyz.wit543.wit.tumboon.model;

/**
 * Created by Asus on 5/28/2016.
 */
public class LayerManager {
    private Layer layer;
    private int level;
    private long nextProduceTime;
    private static final int speedIncreasePerSec = 10;

    public LayerManager(Layer layer){
        this.layer = layer;
        level = 1;
        nextProduceTime = System.currentTimeMillis()+ this.getProductionTime().longValue();
    }

    public Double getProductionTime(){
        double netTime = layer.getBaseProductionTime() - (level-1)*speedIncreasePerSec;
        if(netTime < 100){
            netTime = 100;
        }
        return netTime;
    }

    public double getPrice(){
        return Math.floor(layer.getBasePrice()*Math.pow(1.15f,layer.getLevel()-1));
    }

    public void updateNextProductTime(){
        nextProduceTime += this.getProductionTime().longValue();
    }

    public Layer getLayer() {
        return layer;
    }

    public void setLayer(Layer layer) {
        this.layer = layer;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public long getNextProduceTime() {
        return nextProduceTime;
    }

    public void setNextProduceTime(long nextProduceTime) {
        this.nextProduceTime = nextProduceTime;
    }

    public static int getSpeedIncreasePerSec() {
        return speedIncreasePerSec;
    }

    public double getProductOutcome(){
        return layer.getLevel() * layer.getBaseOutcome();
    }

    public void increaseLevel(){
        level++;
    }

    public double produce(){
        this.updateNextProductTime();
        return this.getProductOutcome();
    }

}
