package xyz.wit543.wit.tumboon.model;

/**
 * Created by WIT on 26-May-16.
 */
public class CityFactory extends LayerAbstractFacotory{
    private Constant city = Constant.CITY;

    private Layer standardLayerCreator(Constant.Layer layer){
        Layer.Builder layerBuilder = new  Layer.Builder();

        layerBuilder.baseOutcome(layer.BASE_OUTCOME).
                productionTime(layer.PRODUCTION_TIME).
                name(layer.NAME);
        return layerBuilder.build();
    }
    @Override
    public Layer createDonateMoneyLayer() {
        return standardLayerCreator(city.DONATE_MONEY_LAYER);
    }

    @Override
    public Layer createDonateLandLayer() {
        return standardLayerCreator(city.DONATE_LAND_LAYER);

    }
    @Override
    public Layer createDonateCarLayer() {
        return standardLayerCreator(city.DONATE_CAR_LAYER);
    }

    @Override
    public Layer createDonateAirplaneLayer() {
        return standardLayerCreator(city.DONATE_AIRPLANE_LAYER);

    }

    @Override
    public Layer createParadeLayer() {
        return standardLayerCreator(city.PARADE_LAYER);
    }

    @Override
    public Layer createSouvenirShopLayer() {
        return standardLayerCreator(city.SOUVENIR_SHOP_LAYER);
    }

    @Override
    public Layer createPRLayer() {
        return standardLayerCreator(city.PR_LAYER);
    }
}
