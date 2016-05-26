package xyz.wit543.wit.tumboon.model;

/**
 * Created by WIT on 26-May-16.
 */
public enum Constant {
    WAT(Layer.WAT_DONATE_MONEY_LAYER,Layer.WAT_DONATE_LAND_LAYER,Layer.WAT_DONATE_CAR_LAYER,Layer.WAT_DONATE_AIRPLANE_LAYER,Layer.WAT_PARADE_LAYER,Layer.WAT_SOUVENIR_SHOP_LAYER,Layer.WAT_PR_LAYER),
    CITY(Layer.CITY_DONATE_MONEY_LAYER,Layer.CITY_DONATE_LAND_LAYER,Layer.CITY_DONATE_CAR_LAYER,Layer.CITY_DONATE_AIRPLANE_LAYER,Layer.CITY_PARADE_LAYER,Layer.CITY_SOUVENIR_SHOP_LAYER,Layer.CITY_PR_LAYER),
    JUNGLE(Layer.JUNGLE_DONATE_MONEY_LAYER,Layer.JUNGLE_DONATE_LAND_LAYER,Layer.JUNGLE_DONATE_CAR_LAYER,Layer.JUNGLE_DONATE_AIRPLANE_LAYER,Layer.JUNGLE_PARADE_LAYER,Layer.JUNGLE_SOUVENIR_SHOP_LAYER,Layer.JUNGLE_PR_LAYER),
    HEAVEN(Layer.HEAVEN_DONATE_MONEY_LAYER,Layer.HEAVEN_DONATE_LAND_LAYER,Layer.HEAVEN_DONATE_CAR_LAYER,Layer.HEAVEN_DONATE_AIRPLANE_LAYER,Layer.HEAVEN_PARADE_LAYER,Layer.HEAVEN_SOUVENIR_SHOP_LAYER,Layer.HEAVEN_PR_LAYER);
    Constant(Layer donate_money_layer, Layer donate_land_layer, Layer donate_car_layer, Layer donate_airplane_layer, Layer parade_layer, Layer souvenir_shop_layer, Layer pr_layer) {
        DONATE_MONEY_LAYER = donate_money_layer;
        DONATE_LAND_LAYER = donate_land_layer;
        DONATE_CAR_LAYER = donate_car_layer;
        DONATE_AIRPLANE_LAYER = donate_airplane_layer;
        PARADE_LAYER = parade_layer;
        SOUVENIR_SHOP_LAYER = souvenir_shop_layer;
        PR_LAYER = pr_layer;
    }

    public enum Layer{
        WAT_DONATE_MONEY_LAYER(10,20,""),
        WAT_DONATE_LAND_LAYER(10,25,""),
        WAT_DONATE_CAR_LAYER(10,10,""),
        WAT_DONATE_AIRPLANE_LAYER(10,10,""),
        WAT_PARADE_LAYER(10,10,""),
        WAT_SOUVENIR_SHOP_LAYER(10,10,""),
        WAT_PR_LAYER(10,10,""),

        CITY_DONATE_MONEY_LAYER(10,20,""),
        CITY_DONATE_LAND_LAYER(10,25,""),
        CITY_DONATE_CAR_LAYER(10,10,""),
        CITY_DONATE_AIRPLANE_LAYER(10,10,""),
        CITY_PARADE_LAYER(10,10,""),
        CITY_SOUVENIR_SHOP_LAYER(10,10,""),
        CITY_PR_LAYER(10,10,""),

        JUNGLE_DONATE_MONEY_LAYER(10,20,""),
        JUNGLE_DONATE_LAND_LAYER(10,25,""),
        JUNGLE_DONATE_CAR_LAYER(10,10,""),
        JUNGLE_DONATE_AIRPLANE_LAYER(10,10,""),
        JUNGLE_PARADE_LAYER(10,10,""),
        JUNGLE_SOUVENIR_SHOP_LAYER(10,10,""),
        JUNGLE_PR_LAYER(10,10,""),

        HEAVEN_DONATE_MONEY_LAYER(10,20,""),
        HEAVEN_DONATE_LAND_LAYER(10,25,""),
        HEAVEN_DONATE_CAR_LAYER(10,10,""),
        HEAVEN_DONATE_AIRPLANE_LAYER(10,10,""),
        HEAVEN_PARADE_LAYER(10,10,""),
        HEAVEN_SOUVENIR_SHOP_LAYER(10,10,""),
        HEAVEN_PR_LAYER(10,10,"");

        public final double BASE_OUTCOME;
        public final int PRODUCTION_TIME;
        public final String NAME;
        Layer(double baseOutcome, int productionTIme, String name){
            this.BASE_OUTCOME=baseOutcome;
            this.PRODUCTION_TIME=productionTIme;
            this.NAME=name;
        }
    }
    public final Layer DONATE_MONEY_LAYER;
    public final Layer DONATE_LAND_LAYER;
    public final Layer DONATE_CAR_LAYER;
    public final Layer DONATE_AIRPLANE_LAYER;
    public final Layer PARADE_LAYER;
    public final Layer SOUVENIR_SHOP_LAYER;
    public final Layer PR_LAYER;


}
