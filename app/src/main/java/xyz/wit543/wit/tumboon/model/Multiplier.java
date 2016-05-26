package xyz.wit543.wit.tumboon.model;

/**
 * Created by Asus on 5/26/2016.
 */
public class Multiplier {
    public long startTime;
    public long duration;
    public double multiply;

    public Multiplier(long startTime , long duration , double multiply){
        this.startTime = startTime;
        this.duration = duration;
        this.multiply = multiply;
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

    public double getMultiply() {
        return multiply;
    }

    public void setMultiply(double multiply) {
        this.multiply = multiply;
    }
}
