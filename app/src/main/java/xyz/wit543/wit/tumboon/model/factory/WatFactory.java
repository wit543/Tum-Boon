package xyz.wit543.wit.tumboon.model.factory;

import java.util.ArrayList;
import java.util.List;

import xyz.wit543.wit.tumboon.R;
import xyz.wit543.wit.tumboon.model.Game;
import xyz.wit543.wit.tumboon.model.Layer;
import xyz.wit543.wit.tumboon.model.LayerConstant;
import xyz.wit543.wit.tumboon.model.LayerManager;
import xyz.wit543.wit.tumboon.model.MapConstant;
import xyz.wit543.wit.tumboon.model.Multiplier;
import xyz.wit543.wit.tumboon.model.Upgrade;

/**
 * Created by WIT on 26-May-16.
 */
public class WatFactory extends LayerAbstractFactory {

    private MapConstant wat = MapConstant.WAT;

    private Layer standardLayerCreator(MapConstant.Layer layer) {
        Layer.Builder layerBuilder = new Layer.Builder();

        layerBuilder.baseOutcome(layer.BASE_OUTCOME).
                productionTime(layer.BASE_PRODUCTION_TIME).
                name(layer.NAME).basePrice(layer.BASE_PRICE).layerPic(layer.LAYER_PIC);
        return layerBuilder.build();
    }

    private LayerManager standardLayerManagerCreator(MapConstant.Layer layer) {
        return new LayerManager(standardLayerCreator(layer),0);
    }

    @Override
    public Layer getLayer(String type) {
        if (LayerConstant.DONATE_MONEY_LAYER.layerName.equalsIgnoreCase(type)) {
            return standardLayerCreator(wat.DONATE_MONEY_LAYER);
        } else if (LayerConstant.DONATE_LAND_LAYER.layerName.equalsIgnoreCase(type)) {
            return standardLayerCreator(wat.DONATE_LAND_LAYER);
        } else if (LayerConstant.DONATE_CAR_LAYER.layerName.equalsIgnoreCase(type)) {
            return standardLayerCreator(wat.DONATE_CAR_LAYER);
        } else if (LayerConstant.DONATE_AIRPLANE_LAYER.layerName.equalsIgnoreCase(type)) {
            return standardLayerCreator(wat.DONATE_AIRPLANE_LAYER);
        } else if (LayerConstant.BLACK_HOLE_LAYER.layerName.equalsIgnoreCase(type)) {
            return standardLayerCreator(wat.PARADE_LAYER);
        } else if (LayerConstant.PARADE_LAYER.layerName.equalsIgnoreCase(type)) {
            return standardLayerCreator(wat.SOUVENIR_SHOP_LAYER);
        } else if (LayerConstant.HUMAN_WALL_LAYER.layerName.equalsIgnoreCase(type)) {
            return standardLayerCreator(wat.PR_LAYER);
        }
        return null;
    }

    @Override
    public List<LayerManager> getAllLayer() {
        List<LayerManager> layerManagers = new ArrayList<LayerManager>();
        layerManagers.add(standardLayerManagerCreator(wat.DONATE_MONEY_LAYER));
        layerManagers.add(standardLayerManagerCreator(wat.DONATE_LAND_LAYER));
        layerManagers.add(standardLayerManagerCreator(wat.DONATE_CAR_LAYER));
        layerManagers.add(standardLayerManagerCreator(wat.DONATE_AIRPLANE_LAYER));
        layerManagers.add(standardLayerManagerCreator(wat.PARADE_LAYER));
        layerManagers.add(standardLayerManagerCreator(wat.SOUVENIR_SHOP_LAYER));
        layerManagers.add(standardLayerManagerCreator(wat.PR_LAYER));
        return layerManagers;
    }

    public List<Upgrade> getAllUpgrade(){
        List<Upgrade> upgrades = new ArrayList<Upgrade>();
        List<LayerManager> layerManagers = getAllLayer();
//        for(LayerConstant layerConstant : LayerConstant.values()){
//            upgrades.add(new Upgrade(layerConstant.layerName , layerConstant.layerName+" Upgrade" , 10000));
//        }

        for(LayerManager layerManager : layerManagers){
            Layer layer = layerManager.getLayer();
            upgrades.add(new Upgrade(layer.getName() , layer.getName()+" อัพเกรด" , layer.getBasePrice()*Game.upgradeTimes));
        }
        return upgrades;
    }

    public List<Multiplier> getAllMultiplier() {
        List<Multiplier> multipliers = new ArrayList<Multiplier>();
        multipliers.add(new Multiplier("เดินพาเรด",0,100000,4));
        multipliers.add(new Multiplier("ใบ้หวย",0,100000,2));
        multipliers.add(new Multiplier("โดนหมายจับ",0,100000,0.5));

        return  multipliers;
    }

}
