package xyz.wit543.wit.tumboon.model;

import java.util.List;

/**
 * Created by WIT on 21-May-16.
 */
public class BoonCalculator {
    /**
     * Calculate money from the given layer. If produce outcome is finished, the total outcome will increase from that layer's outcome
     *
     * @param gameTime
     * @param layers
     * @return
     */
    public double calculateBoon(int gameTime, List<Layer> layers){
        double outcome=0;
        for(Layer l : layers){
            if(gameTime%l.getProductionTime()<=100){ // STILL BUG WHEN TIME GROW BIGGER.
                outcome+=l.getOutcome();
                System.out.printf("GET %f FROM %s AT %d\n",l.getOutcome(),l.getName() , gameTime);
            }
        }

        return outcome;

    }

}
