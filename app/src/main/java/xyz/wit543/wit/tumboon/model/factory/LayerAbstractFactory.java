package xyz.wit543.wit.tumboon.model.factory;

import java.util.List;

import xyz.wit543.wit.tumboon.model.Layer;
import xyz.wit543.wit.tumboon.model.LayerManager;
import xyz.wit543.wit.tumboon.model.Multiplier;
import xyz.wit543.wit.tumboon.model.Upgrade;

/**
 * Created by WIT on 22-May-16.
 */
public abstract class LayerAbstractFactory {
//    public abstract Layer createDonateMoneyLayer();
//    public abstract Layer createDonateLandLayer();
//    public abstract Layer createDonateCarLayer();
//    public abstract Layer createDonateAirplaneLayer();
//    public abstract Layer createParadeLayer();
//    public abstract Layer createSouvenirShopLayer();
//    public abstract Layer createPRLayer();
    public abstract Layer getLayer(String  constant);
    public abstract List<LayerManager> getAllLayer();
    public abstract List<Upgrade> getAllUpgrade();
    public abstract List<Multiplier> getAllMultiplier();
}
