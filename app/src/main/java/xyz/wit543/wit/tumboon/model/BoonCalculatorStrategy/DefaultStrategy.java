package xyz.wit543.wit.tumboon.model.BoonCalculatorStrategy;

import java.util.List;

import xyz.wit543.wit.tumboon.model.Layer;

/**
 * Created by Asus on 5/26/2016.
 */
public class DefaultStrategy implements CalculateStrategy{

    private static DefaultStrategy ds = null;

    public static DefaultStrategy getInstance(){
        if(ds == null)
            ds = new DefaultStrategy();

        return ds;
    }

    @Override
    public double calculateBoon(int gameTime , List<Layer> layers) {
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
