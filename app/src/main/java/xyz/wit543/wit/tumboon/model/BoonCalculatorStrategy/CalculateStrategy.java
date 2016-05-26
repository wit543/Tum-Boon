package xyz.wit543.wit.tumboon.model.BoonCalculatorStrategy;

import java.util.List;

import xyz.wit543.wit.tumboon.model.Layer;

/**
 * Created by Asus on 5/26/2016.
 */
public interface CalculateStrategy {
    public double calculateBoon(int gameTime,List<Layer> layers);
}
