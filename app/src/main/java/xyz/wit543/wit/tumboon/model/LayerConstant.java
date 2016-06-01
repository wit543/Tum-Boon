package xyz.wit543.wit.tumboon.model;

/**
 * Created by WIT on 26-May-16.
 */
public enum LayerConstant {
    DONATE_MONEY_LAYER("money"),
    DONATE_LAND_LAYER("land"),
    DONATE_CAR_LAYER("car"),
    DONATE_AIRPLANE_LAYER("airplane"),
    BLACK_HOLE_LAYER("blackhole"),
    PARADE_LAYER("parade"),
    HUMAN_WALL_LAYER("humanwall");

    public final String layerName;

    LayerConstant(String layerName){
        this.layerName = layerName;
    }
}
