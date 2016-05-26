package xyz.wit543.wit.tumboon.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by WIT on 26-May-16.
 */
public class MapFactory {
    public Map createMap(MapConstant constant){
        Map.Builder builder = new Map.Builder();
        LayerAbstractFactory layerAbstractFactory = FactoryProducer.getFactory(MapConstant.WAT);;
        if(constant == MapConstant.WAT){
            builder.name("wat");
            assert layerAbstractFactory != null;
            List<Layer> list = new ArrayList<>(Arrays.asList(new Layer[]{
                    layerAbstractFactory.getLayer("donateMoney"),
                    layerAbstractFactory.getLayer("donateCar")
            }));

            builder.layers(list).layerBuyRate(MapConstant.CITY.BUY_RATE).productionBonus(MapConstant.CITY.PRODUCTION_BONUS);
        }else if(constant == MapConstant.CITY){
            //TODO
        }else if(constant == MapConstant.JUNGLE){
            //TODO
        }else if(constant == MapConstant.HEAVEN){
            //TODO
        }
        return builder.build();
    }
}
