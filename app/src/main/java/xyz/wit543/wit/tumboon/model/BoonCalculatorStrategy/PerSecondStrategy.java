package xyz.wit543.wit.tumboon.model.BoonCalculatorStrategy;

import java.util.List;

import xyz.wit543.wit.tumboon.model.LayerManager;

/**
 * Created by Asus on 6/1/2016.
 */
public class PerSecondStrategy implements CalculateStrategy {

    private static PerSecondStrategy ps = null;
    int[] nextProduceTimes;

    public static PerSecondStrategy getInstance(){
        if(ps == null)
            ps = new PerSecondStrategy();

        return ps;
    }

    public double calculateBoon(long currentTime , List<LayerManager> layers) {
        if(nextProduceTimes == null)
            nextProduceTimes = new int[layers.size()];

        int outcome=0;
        for(int i=0 ; i<layers.size(); i++){
            LayerManager l = layers.get(i);
            outcome+=l.produce()*(1+(l.getUpgrade()/100));
                    // System.out.printf("GET %d FROM %s AT %d NEXT PRODUCE TIME IS %d \n",l.getOutcome(),l.getName() , gameTime , nextProduceTimes[i]);
        }
        return outcome;
    }

}
