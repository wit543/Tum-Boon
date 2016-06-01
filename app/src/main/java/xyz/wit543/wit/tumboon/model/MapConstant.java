package xyz.wit543.wit.tumboon.model;

import xyz.wit543.wit.tumboon.R;

/**
 * Created by WIT on 26-May-16.
 */
public enum MapConstant {
    WAT(10,10, Layer.WAT_DONATE_MONEY_LAYER,Layer.WAT_DONATE_LAND_LAYER,Layer.WAT_DONATE_CAR_LAYER,Layer.WAT_DONATE_AIRPLANE_LAYER,Layer.WAT_BLACK_HOLE_LAYER,Layer.WAT_PARADE_LAYER,Layer.WAT_HUMAN_WALL_LAYER)
    ,CITY(10,10,Layer.CITY_DONATE_MONEY_LAYER,Layer.CITY_DONATE_LAND_LAYER,Layer.CITY_DONATE_CAR_LAYER,Layer.CITY_DONATE_AIRPLANE_LAYER,Layer.CITY_PARADE_LAYER,Layer.CITY_SOUVENIR_SHOP_LAYER,Layer.CITY_PR_LAYER),
    JUNGLE(10,10,Layer.JUNGLE_DONATE_MONEY_LAYER,Layer.JUNGLE_DONATE_LAND_LAYER,Layer.JUNGLE_DONATE_CAR_LAYER,Layer.JUNGLE_DONATE_AIRPLANE_LAYER,Layer.JUNGLE_PARADE_LAYER,Layer.JUNGLE_SOUVENIR_SHOP_LAYER,Layer.JUNGLE_PR_LAYER),
    HEAVEN(10,10,Layer.HEAVEN_DONATE_MONEY_LAYER,Layer.HEAVEN_DONATE_LAND_LAYER,Layer.HEAVEN_DONATE_CAR_LAYER,Layer.HEAVEN_DONATE_AIRPLANE_LAYER,Layer.HEAVEN_PARADE_LAYER,Layer.HEAVEN_SOUVENIR_SHOP_LAYER,Layer.HEAVEN_PR_LAYER);


    public enum Layer{
        WAT_DONATE_MONEY_LAYER("บริจาคเงิน",40,10, 1000 , R.drawable.money_layer ),
        WAT_DONATE_LAND_LAYER("บริจาคที่ดิน",200,150,5000 , R.drawable.land_layer),
        WAT_DONATE_CAR_LAYER("บริจาครถ",1300,500,10000, R.drawable.car_layer),
        WAT_DONATE_AIRPLANE_LAYER("บริจาคเครื่องบิน",8500,5000,20000 , R.drawable.plane_layer),

        WAT_BLACK_HOLE_LAYER("วางรถแบล็คโฮล์",32000,10000,100000, R.drawable.backhole_layer),
        WAT_PARADE_LAYER("จัดพาเรด",150000,100000,250000 , R.drawable.parade_layer),
        WAT_HUMAN_WALL_LAYER("กำแพงมนุษย์",1000000,999999,500000 , R.drawable.humanwall_layer),

        CITY_DONATE_MONEY_LAYER("Money",10,20, 10),
        CITY_DONATE_LAND_LAYER("Land",10,20,10),
        CITY_DONATE_CAR_LAYER("Car",10,20,10),
        CITY_DONATE_AIRPLANE_LAYER("Airplane",10,20,10),
        CITY_PARADE_LAYER("Parade",10,20,10),
        CITY_SOUVENIR_SHOP_LAYER("Souvenir",10,20,10),
        CITY_PR_LAYER("Pr",10,20,10),

        JUNGLE_DONATE_MONEY_LAYER("Money",10,20, 10),
        JUNGLE_DONATE_LAND_LAYER("Land",10,20,10),
        JUNGLE_DONATE_CAR_LAYER("Car",10,20,10),
        JUNGLE_DONATE_AIRPLANE_LAYER("Airplane",10,20,10),
        JUNGLE_PARADE_LAYER("Parade",10,20,10),
        JUNGLE_SOUVENIR_SHOP_LAYER("Souvenir",10,20,10),
        JUNGLE_PR_LAYER("Pr",10,20,10),

        HEAVEN_DONATE_MONEY_LAYER("Money",10,20, 10),
        HEAVEN_DONATE_LAND_LAYER("Land",10,20,10),
        HEAVEN_DONATE_CAR_LAYER("Car",10,20,10),
        HEAVEN_DONATE_AIRPLANE_LAYER("Airplane",10,20,10),
        HEAVEN_PARADE_LAYER("Parade",10,20,10),
        HEAVEN_SOUVENIR_SHOP_LAYER("Souvenir",10,20,10),
        HEAVEN_PR_LAYER("Pr",10,20,10);

        public final String NAME;
        public final double BASE_PRICE;
        public final double BASE_OUTCOME;
        public final int BASE_PRODUCTION_TIME;
        public final int LAYER_PIC;

        Layer(String name , double basePrice , double baseOutcome, int baseProductionTime){
            this.NAME=name;
            this.BASE_PRICE = basePrice;
            this.BASE_OUTCOME=baseOutcome;
            this.BASE_PRODUCTION_TIME=baseProductionTime;
            this.LAYER_PIC = 0;
        }

        Layer(String name , double basePrice , double baseOutcome, int baseProductionTime , int layerPic){
            this.NAME=name;
            this.BASE_PRICE = basePrice;
            this.BASE_OUTCOME=baseOutcome;
            this.BASE_PRODUCTION_TIME=baseProductionTime;
            this.LAYER_PIC = layerPic;
        }
    }
    public final Layer DONATE_MONEY_LAYER;
    public final Layer DONATE_LAND_LAYER;
    public final Layer DONATE_CAR_LAYER;
    public final Layer DONATE_AIRPLANE_LAYER;
    public final Layer PARADE_LAYER;
    public final Layer SOUVENIR_SHOP_LAYER;
    public final Layer PR_LAYER;
    public final double BUY_RATE;
    public final double PRODUCTION_BONUS;
    MapConstant(double buy_rate, double production_bonus, Layer donate_money_layer, Layer donate_land_layer, Layer donate_car_layer, Layer donate_airplane_layer, Layer parade_layer, Layer souvenir_shop_layer, Layer pr_layer) {
        BUY_RATE = buy_rate;
        DONATE_MONEY_LAYER = donate_money_layer;
        DONATE_LAND_LAYER = donate_land_layer;
        DONATE_CAR_LAYER = donate_car_layer;
        DONATE_AIRPLANE_LAYER = donate_airplane_layer;
        PARADE_LAYER = parade_layer;
        SOUVENIR_SHOP_LAYER = souvenir_shop_layer;
        PR_LAYER = pr_layer;
        PRODUCTION_BONUS = production_bonus;
    }

}
