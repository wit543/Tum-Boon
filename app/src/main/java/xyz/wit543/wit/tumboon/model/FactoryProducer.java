package xyz.wit543.wit.tumboon.model;

/**
 * Created by WIT on 26-May-16.
 */
public class FactoryProducer {
    public static LayerAbstractFactory getFactory(MapConstant constant){
        if(constant == MapConstant.JUNGLE){
            return new JungleFactory();
        }else if (constant == MapConstant.CITY){
            return new CityFactory();
        }else if(constant == MapConstant.HEAVEN){
            return new HeavenFactory();
        }else if(constant == MapConstant.WAT){
            return new WatFactory();
        }
        return null;
    }
}
