package xyz.wit543.wit.tumboon.model.factory;

import java.util.ArrayList;
import java.util.List;

import xyz.wit543.wit.tumboon.R;
import xyz.wit543.wit.tumboon.model.Layer;
import xyz.wit543.wit.tumboon.model.LayerManager;
import xyz.wit543.wit.tumboon.model.MapConstant;

/**
 * Created by WIT on 26-May-16.
 */
public class WatFactory extends LayerAbstractFactory {
//    static final double WAT_DONATE_MONEY_LAYER_BASE_OUTCOME = 10;
//    static final int WAT_DONATE_MONEY_LAYER_PRODUCTION_TIME= 10;
//    static final String WAT_DONATE_MONEY_LAYER_NAME = "Donate Money";
//
//    static final double WAT_DONATE_LAND_LAYER_BASE_OUTCOME=10;
//    static final int WAT_DONATE_LAND_LAYER_PRODUCTION_TIME=10;
//    static final String WAT_DONATE_LAND_LAYER_NAME = "Donate Land";
//
//    static final double WAT_DONATE_CAR_LAYER_BASE_OUTCOME=10;
//    static final int WAT_DONATE_CAR_LAYER_PRODUCTION_TIME=10;
//    static final String WAT_DONATE_CAR_LAYER_NAME = "Donate Car";
//
//    static final double WAT_DONATE_AIRPLANE_LAYER_BASE_OUTCOME=10;
//    static final int WAT_DONATE_AIRPLANE_LAYER_PRODUCTION_TIME=10;
//    static final String WAT_DONATE_AIRPLANE_LAYER_NAME = "Donate Airplane";
//
//    static final double WAT_PARADE_LAYER_BASE_OUTCOME=10;
//    static final int WAT_PARADE_LAYER_PRODUCTION_TIME=10;
//    static final String WAT_OARADE_LAYER_LAYER_NAME = "Parade";
//
//    static final double WAT_SOUVENIR_SHOP_LAYER_BASE_OUTCOME=10;
//    static final int WAT_SOUVENIR_SHOP_LAYER_PRODUCTION_TIME=10;
//    static final String WAT_SOUVENIR_SHOP_LAYER_NAME = "Souvenir";
//
//    static final double WAT_PR_LAYER_BASE_OUTCOME=10;
//    static final int WAT_PR_LAYER_PRODUCTION_TIME=10;
//    static final String WAT_PR_LAYER_NAME = "PR";

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
        if ("donateMoney".equalsIgnoreCase(type)) {
            return standardLayerCreator(wat.DONATE_MONEY_LAYER);
        } else if ("donateLand".equalsIgnoreCase(type)) {
            return standardLayerCreator(wat.DONATE_LAND_LAYER);
        } else if ("donateCar".equalsIgnoreCase(type)) {
            return standardLayerCreator(wat.DONATE_CAR_LAYER);
        } else if ("donateAirplane".equalsIgnoreCase(type)) {
            return standardLayerCreator(wat.DONATE_AIRPLANE_LAYER);
        } else if ("parade".equalsIgnoreCase(type)) {
            return standardLayerCreator(wat.PARADE_LAYER);
        } else if ("souvenirShop".equalsIgnoreCase(type)) {
            return standardLayerCreator(wat.SOUVENIR_SHOP_LAYER);
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
        return layerManagers;
    }

}
//    @Override
//    public Layer createDonateMoneyLayer() {
//        return standardLayerCreator(wat.DONATE_MONEY_LAYER);
//    }
//
//    @Override
//    public Layer createDonateLandLayer() {
//        return standardLayerCreator(wat.DONATE_LAND_LAYER);
//
//    }
//    @Override
//    public Layer createDonateCarLayer() {
//        return standardLayerCreator(wat.DONATE_CAR_LAYER);
//    }
//
//    @Override
//    public Layer createDonateAirplaneLayer() {
//        return standardLayerCreator(wat.DONATE_AIRPLANE_LAYER);
//
//    }
//
//    @Override
//    public Layer createParadeLayer() {
//        return standardLayerCreator(wat.PARADE_LAYER);
//    }
//
//    @Override
//    public Layer createSouvenirShopLayer() {
//        return standardLayerCreator(wat.SOUVENIR_SHOP_LAYER);
//    }
//
//    @Override
//    public Layer createPRLayer() {
//        return standardLayerCreator(wat.PR_LAYER);
//<<<<<<< HEAD:app/src/main/java/xyz/wit543/wit/tumboon/model/factory/WatFactory.java
////    }
//}
//=======
//    }
//
//>>>>>>> origin/Momo:app/src/main/java/xyz/wit543/wit/tumboon/model/WatFactory.java
