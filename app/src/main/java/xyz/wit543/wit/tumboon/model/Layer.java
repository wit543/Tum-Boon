package xyz.wit543.wit.tumboon.model;

/**
 * Created by WIT on 21-May-16.
 */
public class Layer {
    private String name;
    private int lv;
    private int baseOutcome;
    private int produceTime;

    public Layer(String name,int lv,int baseOutcome,int produceTime){
        this.name = name;
        this.lv = lv;
        this.baseOutcome = baseOutcome;
        this.produceTime = produceTime;
    }

    public int getProduceTime() {
        return produceTime;
    }

    public void setProduceTime(int produceTime) {
        this.produceTime = produceTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLv() {
        return lv;
    }

    public void setLv(int lv) {
        this.lv = lv;
    }

    public int getBaseOutcome() {
        return baseOutcome;
    }

    public void setBaseOutcome(int baseOutcome) {
        this.baseOutcome = baseOutcome;
    }

    public int getOutcome(){
        return lv*baseOutcome;
    }
}