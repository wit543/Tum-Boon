package xyz.wit543.wit.tumboon.model.util;

import java.util.List;

import xyz.wit543.wit.tumboon.model.Multiplier;

/**
 * Created by Asus on 5/29/2016.
 */
public class MultiplierRandomizer {
    private List<Multiplier> multipliers;
    private long lastRandom;
    private final int coolDown = 10000;

    public MultiplierRandomizer(List<Multiplier> multipliers){
        this.multipliers = multipliers;
    }

    public Multiplier randomMultiplier(){
        int random = (int)Math.floor(Math.random()*multipliers.size());
        Multiplier multiplier = multipliers.get(random);
        multiplier.setStartTime(System.currentTimeMillis());
        return multipliers.get(random);
    }

    public boolean canRandom(){
        if(System.currentTimeMillis()>=this.nextRandomTime())
            return true;
        return false;
    }

    public long nextRandomTime(){
        return lastRandom+coolDown;
    }
}
