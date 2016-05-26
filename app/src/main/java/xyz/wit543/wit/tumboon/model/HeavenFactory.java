package xyz.wit543.wit.tumboon.model;

/**
 * Created by WIT on 26-May-16.
 */
public class HeavenFactory extends LayerAbstractFacotory {
    private Constant heaven = Constant.HEAVEN;

    private Layer standardLayerCreator(Constant.Layer layer){
        Layer.Builder layerBuilder = new  Layer.Builder();

        layerBuilder.baseOutcome(layer.BASE_OUTCOME).
                productionTime(layer.PRODUCTION_TIME).
                name(layer.NAME);
        return layerBuilder.build();
    }
    @Override
    public Layer createDonateMoneyLayer() {
        return standardLayerCreator(heaven.DONATE_MONEY_LAYER);
    }

    @Override
    public Layer createDonateLandLayer() {
        return standardLayerCreator(heaven.DONATE_LAND_LAYER);

    }
    @Override
    public Layer createDonateCarLayer() {
        return standardLayerCreator(heaven.DONATE_CAR_LAYER);
    }

    @Override
    public Layer createDonateAirplaneLayer() {
        return standardLayerCreator(heaven.DONATE_AIRPLANE_LAYER);

    }

    @Override
    public Layer createParadeLayer() {
        return standardLayerCreator(heaven.PARADE_LAYER);
    }

    @Override
    public Layer createSouvenirShopLayer() {
        return standardLayerCreator(heaven.SOUVENIR_SHOP_LAYER);
    }

    @Override
    public Layer createPRLayer() {
        return standardLayerCreator(heaven.PR_LAYER);
    }
}
