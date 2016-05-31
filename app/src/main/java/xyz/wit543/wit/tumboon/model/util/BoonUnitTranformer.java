package xyz.wit543.wit.tumboon.model.util;

/**
 * Created by Asus on 5/31/2016.
 */
public class BoonUnitTranformer {
    public static String getReadableValue(double amount){
        double tranformValue = amount;
        String readableValue = "";
        BoonUnit[] units = BoonUnit.values();
        for(BoonUnit unit : units){
            if(amount/unit.unitValue>=1){
                tranformValue=amount/unit.unitValue;
                readableValue=unit.unitName;
            }else{
                break;
            }
        }
        return String.format("%.2f%s",tranformValue,readableValue);
    }
}
