package xyz.wit543.wit.tumboon.model;

/**
 * Created by Asus on 5/28/2016.
 */
public class LayerManager {
    private Layer layer;
    private int level;
    private long nextProduceTime;
    private long startTime;
    private double upgrade;
    private static final int speedIncreasePerSec = 10;

    public LayerManager(Layer layer , int level){
        this.layer = layer;
        this.level = level;
        nextProduceTime = System.currentTimeMillis()+ this.getProductionTime().longValue();
        startTime = System.currentTimeMillis();
        upgrade = 0;
    }

    public double getUpgrade() {
        return upgrade;
    }

    public void setUpgrade(double upgrade) {
        this.upgrade = upgrade;
    }

    public synchronized Double getProductionTime(){
        double netTime = layer.getBaseProductionTime() - (level-1)*speedIncreasePerSec;
        if(netTime < 100){
            netTime = 100;
        }
        return netTime;
    }

    public double getPrice(){
        return Math.floor(layer.getBasePrice()*Math.pow(1.15f,level));
    }

    public boolean canProduce(){
        return !(level==0);
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

    public synchronized long getNextProduceTime() {
        return nextProduceTime;
    }

    public void setNextProduceTime(long nextProduceTime) {
        this.nextProduceTime = nextProduceTime;
    }

    public static int getSpeedIncreasePerSec() {
        return speedIncreasePerSec;
    }

    public double getProductOutcome(){
        return this.getLevel() * layer.getBaseOutcome();
    }

    public void increaseLevel(){
        if(level==0){
            nextProduceTime = System.currentTimeMillis() + this.getProductionTime().longValue();
        }
        level++;
    }

    public void startProduce(){
        nextProduceTime = System.currentTimeMillis();
    }

    public double produce(){
        this.updateNextProductTime();
        return this.getProductOutcome();
    }

}