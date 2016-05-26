package xyz.wit543.wit.tumboon.model;

import java.util.List;

import xyz.wit543.wit.tumboon.model.BoonCalculatorStrategy.CalculateStrategy;
import xyz.wit543.wit.tumboon.model.BoonCalculatorStrategy.DefaultStrategy;

/**
 * Created by WIT on 21-May-16.
 */
public class BoonCalculator {

    private CalculateStrategy calculateStrategy;

    public BoonCalculator(){
        calculateStrategy = DefaultStrategy.getInstance();
    }

    public void setStrategy(CalculateStrategy calculateStrategy){
        this.calculateStrategy = calculateStrategy;
    }

    public double calculateBoon(int gameTime, List<Layer> layers){
        return calculateStrategy.calculateBoon(gameTime,layers);
    }

}
