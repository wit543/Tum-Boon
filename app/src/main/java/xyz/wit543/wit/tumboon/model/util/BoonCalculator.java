package xyz.wit543.wit.tumboon.model.util;

import java.util.List;
import java.util.Observable;

import xyz.wit543.wit.tumboon.model.BoonCalculatorStrategy.CalculateStrategy;
import xyz.wit543.wit.tumboon.model.BoonCalculatorStrategy.DefaultStrategy;
import xyz.wit543.wit.tumboon.model.Layer;
import xyz.wit543.wit.tumboon.model.LayerManager;

/**
 * Created by WIT on 21-May-16.
 */
public class BoonCalculator{

    private CalculateStrategy calculateStrategy;
    private List<LayerManager> layerManagers;
    private final int DELAY = 100;

    public BoonCalculator(List<LayerManager> layerManagers){
        calculateStrategy = DefaultStrategy.getInstance();
        this.layerManagers = layerManagers;
    }

    public void setStrategy(CalculateStrategy calculateStrategy){
        this.calculateStrategy = calculateStrategy;
    }

    public double calculateBoon(Long currentTime, List<LayerManager> layers){
        return calculateStrategy.calculateBoon(currentTime,layers);
    }

}
