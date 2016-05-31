package xyz.wit543.wit.tumboon.model.util;

/**
 * Created by Asus on 5/31/2016.
 */
public enum  BoonUnit {
    THOUSAND("K",1000),
    MILLION("M",1000000),
    BILLION("B",1000000000);

    public final String unitName;
    public final double unitValue;

    BoonUnit(String unitName,double unitValue){
        this.unitName = unitName;
        this.unitValue = unitValue;
    }
}
