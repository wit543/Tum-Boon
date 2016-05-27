package xyz.wit543.wit.tumboon.model.BoonCalculatorStrategy;

import java.util.List;

import xyz.wit543.wit.tumboon.model.Layer;

/**
 * Created by Asus on 5/26/2016.
 */
public class DefaultStrategy implements CalculateStrategy{

    private final double speedIncreasePerSec = 5;

    private static DefaultStrategy ds = null;
    int[] nextProduceTimes;

    public static DefaultStrategy getInstance(){
        if(ds == null)
            ds = new DefaultStrategy();

        return ds;
    }

    @Override
    public double calculateBoon(int gameTime , List<Layer> layers) {
        if(nextProduceTimes == null)
            nextProduceTimes = new int[layers.size()];

        int outcome=0;
        for(int i=0 ; i<layers.size(); i++){
            Layer l = layers.get(i);
            if(gameTime>=nextProduceTimes[i]){
                nextProduceTimes[i] += getProductionTime(l);
                getProductionTime(l);
                outcome+=getProductOutcome(l);
                //System.out.printf("GET %d FROM %s AT %d NEXT PRODUCE TIME IS %d \n",l.getOutcome(),l.getName() , gameTime , nextProduceTimes[i]);
            }
        }
        return outcome;
    }

    public double getProductionTime(Layer l){
        double netTime = l.getBaseProductionTime() - (l.getLevel()-1)*speedIncreasePerSec;
        if(netTime < 100){
            netTime = 100;
        }
        return netTime;

    }

    public double getProductOutcome(Layer l){
        return l.getLevel() * l.getBaseOutcome();
    }
}
