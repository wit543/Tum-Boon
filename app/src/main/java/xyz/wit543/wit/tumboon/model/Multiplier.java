package xyz.wit543.wit.tumboon.model;

/**
 * Created by Asus on 5/26/2016.
 */
public class Multiplier {
    private String name;
    public long startTime;
    public long duration;
    public double multiply;
    private String multiplierDetail;
    private int multiplierPic;

    public Multiplier(String name, long startTime , long duration , double multiply, String multiplierDetail, int multiplierPic){
        this.name = name;
        this.startTime = startTime;
        this.duration = duration;
        this.multiply = multiply;
        this.multiplierDetail = multiplierDetail;
        this.multiplierPic = multiplierPic;
    }

    public String getMultiplierDetail() {
        return multiplierDetail;
    }

    public void setMultiplierDetail(String multiplierDetail) {
        this.multiplierDetail = multiplierDetail;
    }

    public int getMultiplierPic() {
        return multiplierPic;
    }

    public void setMultiplierPic(int multiplierPic) {
        this.multiplierPic = multiplierPic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public long getRemainingTime(){
        return this.startTime+duration - System.currentTimeMillis();
    }

    public double getMultiply() {
        return multiply;
    }

    public void setMultiply(double multiply) {
        this.multiply = multiply;
    }
}
