package xyz.wit543.wit.tumboon.model;

/**
 * Created by WIT on 22-May-16.
 */
public interface LayerAbstractFacotory {
    Layer createDonateMoneyLayer();
    Layer createDonateLandLayer();
    Layer createDonateCarLayer();
    Layer createDonateAirplaneLayer();
    Layer createparadeLayer();
    Layer createSouvenirShopLayer();
    Layer createPRLayer();
}
