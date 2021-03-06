package xyz.wit543.wit.tumboon.model.BoonCalculatorStrategy;

import java.util.List;

import xyz.wit543.wit.tumboon.model.Layer;
import xyz.wit543.wit.tumboon.model.LayerManager;

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
    public double calculateBoon(long currentTime , List<LayerManager> layers) {
        if(nextProduceTimes == null)
            nextProduceTimes = new int[layers.size()];

        int outcome=0;
        for(int i=0 ; i<layers.size(); i++){
            LayerManager l = layers.get(i);
            if(l.canProduce()){
                if(currentTime>=l.getNextProduceTime()){
                    outcome+=l.produce()*(1+(l.getUpgrade()/100));
                    // System.out.printf("GET %d FROM %s AT %d NEXT PRODUCE TIME IS %d \n",l.getOutcome(),l.getName() , gameTime , nextProduceTimes[i]);
                }
            }
        }
        return outcome;
    }

}