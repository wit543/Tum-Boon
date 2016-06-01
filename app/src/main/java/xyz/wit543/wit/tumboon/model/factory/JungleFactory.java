package xyz.wit543.wit.tumboon.model.factory;

import java.util.List;

import xyz.wit543.wit.tumboon.model.Layer;
import xyz.wit543.wit.tumboon.model.LayerManager;
import xyz.wit543.wit.tumboon.model.MapConstant;
import xyz.wit543.wit.tumboon.model.Multiplier;
import xyz.wit543.wit.tumboon.model.Upgrade;

/**
 * Created by WIT on 26-May-16.
 */
public class JungleFactory extends LayerAbstractFactory {
    private MapConstant jungle = MapConstant.JUNGLE;

    private Layer standardLayerCreator(MapConstant.Layer layer){

        Layer.Builder layerBuilder = new  Layer.Builder();

        layerBuilder.baseOutcome(layer.BASE_OUTCOME).
                productionTime(layer.BASE_PRODUCTION_TIME).
                name(layer.NAME).basePrice(layer.BASE_PRICE);
        return layerBuilder.build();
    }

    public List<Upgrade> getAllUpgrade(){return null;}

    public List<Multiplier> getAllMultiplier() { return null;}
    @Override
    public Layer getLayer(String type) {
        if("donateMoney".equalsIgnoreCase(type)){
            return standardLayerCreator(jungle.DONATE_MONEY_LAYER);
        }
        else if("donateLand".equalsIgnoreCase(type)){
            return standardLayerCreator(jungle.DONATE_LAND_LAYER);
        }
        else if("donateCar".equalsIgnoreCase(type)){
            return standardLayerCreator(jungle.DONATE_CAR_LAYER);
        }
        else if("donateAirplane".equalsIgnoreCase(type)){
            return standardLayerCreator(jungle.DONATE_AIRPLANE_LAYER);
        }
        else if("parade".equalsIgnoreCase(type)){
            return standardLayerCreator(jungle.PARADE_LAYER);
        }
        else if("souvenirShop".equalsIgnoreCase(type)){
            return standardLayerCreator(jungle.SOUVENIR_SHOP_LAYER);
        }
        return null;
    }

    @Override
    public List<LayerManager> getAllLayer() {
        return null;
    }
//    @Override
//    public Layer createDonateMoneyLayer() {
//        return standardLayerCreator(jungle.DONATE_MONEY_LAYER);
//    }
//
//    @Override
//    public Layer createDonateLandLayer() {
//        return standardLayerCreator(jungle.DONATE_LAND_LAYER);
//
//    }
//    @Override
//    public Layer createDonateCarLayer() {
//        return standardLayerCreator(jungle.DONATE_CAR_LAYER);
//    }
//
//    @Override
//    public Layer createDonateAirplaneLayer() {
//        return standardLayerCreator(jungle.DONATE_AIRPLANE_LAYER);
//
//    }
//
//    @Override
//    public Layer createParadeLayer() {
//        return standardLayerCreator(jungle.PARADE_LAYER);
//    }
//
//    @Override
//    public Layer createSouvenirShopLayer() {
//        return standardLayerCreator(jungle.SOUVENIR_SHOP_LAYER);
//    }
//
//    @Override
//    public Layer createPRLayer() {
//        return standardLayerCreator(jungle.PR_LAYER);
//    }
}
