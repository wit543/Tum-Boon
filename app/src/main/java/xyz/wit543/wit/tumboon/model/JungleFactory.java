package xyz.wit543.wit.tumboon.model;

/**
 * Created by WIT on 26-May-16.
 */
public class JungleFactory extends LayerAbstractFacotory {
    private Constant jungle = Constant.JUNGLE;

    private Layer standardLayerCreator(Constant.Layer layer){

        Layer.Builder layerBuilder = new  Layer.Builder();

        layerBuilder.baseOutcome(layer.BASE_OUTCOME).
                productionTime(layer.PRODUCTION_TIME).
                name(layer.NAME);
        return layerBuilder.build();
    }
    @Override
    public Layer createDonateMoneyLayer() {
        return standardLayerCreator(jungle.DONATE_MONEY_LAYER);
    }

    @Override
    public Layer createDonateLandLayer() {
        return standardLayerCreator(jungle.DONATE_LAND_LAYER);

    }
    @Override
    public Layer createDonateCarLayer() {
        return standardLayerCreator(jungle.DONATE_CAR_LAYER);
    }

    @Override
    public Layer createDonateAirplaneLayer() {
        return standardLayerCreator(jungle.DONATE_AIRPLANE_LAYER);

    }

    @Override
    public Layer createParadeLayer() {
        return standardLayerCreator(jungle.PARADE_LAYER);
    }

    @Override
    public Layer createSouvenirShopLayer() {
        return standardLayerCreator(jungle.SOUVENIR_SHOP_LAYER);
    }

    @Override
    public Layer createPRLayer() {
        return standardLayerCreator(jungle.PR_LAYER);
    }
}
