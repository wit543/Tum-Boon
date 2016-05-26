package xyz.wit543.wit.tumboon.model;

/**
 * Created by WIT on 26-May-16.
 */
public class WatFactory extends LayerAbstractFacotory {
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

    private Constant wat = Constant.WAT;

    private Layer standardLayerCreator(Constant.Layer layer){
        Layer.Builder layerBuilder = new  Layer.Builder();

        layerBuilder.baseOutcome(layer.BASE_OUTCOME).
                productionTime(layer.PRODUCTION_TIME).
                name(layer.NAME);
        return layerBuilder.build();
    }
    @Override
    public Layer createDonateMoneyLayer() {
        return standardLayerCreator(wat.DONATE_MONEY_LAYER);
    }

    @Override
    public Layer createDonateLandLayer() {
        return standardLayerCreator(wat.DONATE_LAND_LAYER);

    }
    @Override
    public Layer createDonateCarLayer() {
        return standardLayerCreator(wat.DONATE_CAR_LAYER);
    }

    @Override
    public Layer createDonateAirplaneLayer() {
        return standardLayerCreator(wat.DONATE_AIRPLANE_LAYER);

    }

    @Override
    public Layer createParadeLayer() {
        return standardLayerCreator(wat.PARADE_LAYER);
    }

    @Override
    public Layer createSouvenirShopLayer() {
        return standardLayerCreator(wat.SOUVENIR_SHOP_LAYER);
    }

    @Override
    public Layer createPRLayer() {
        return standardLayerCreator(wat.PR_LAYER);
    }
}
