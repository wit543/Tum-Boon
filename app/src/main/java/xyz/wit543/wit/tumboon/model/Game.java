package xyz.wit543.wit.tumboon.model;

/**
 * Created by WIT on 21-May-16.
 */
import java.util.ArrayList;
import java.util.List;

import xyz.wit543.wit.tumboon.model.util.BoonCalculator;
import xyz.wit543.wit.tumboon.model.util.MultiplierRandomizer;

public class Game {
    private static Game game;
    private List<LayerManager> layerManagers;
    private List<Map> maps;
    private List<Upgrade> upgrades;
    private double money;
    private boolean running;
    private long startTime;
    private Multiplier multiplier;

    private BoonCalculator mc;
    private MultiplierRandomizer mr;

    private final int DELAY = 100;

    private Game(){

        List<Multiplier> multipliers = new ArrayList<Multiplier>();
        multipliers.add(new Multiplier("แสดงอภินิหาร",0,100000,4));
        multipliers.add(new Multiplier("ใบ้หวย",0,100000,2));

        mc = new BoonCalculator();
        mr = new MultiplierRandomizer(multipliers);

        upgrades = new ArrayList<Upgrade>();

        layerManagers = new ArrayList<LayerManager>();
        layerManagers.add(new LayerManager(new Layer("Car" , 1 ,1000,100 , 1000) , 0));
        layerManagers.add(new LayerManager(new Layer("Helicopter" , 1 ,3000, 200 , 3000),0));
        multiplier = new Multiplier("FUCK",System.currentTimeMillis(),100000,4);
        money = 1000;
    }

    public static Game getInstance(){
        if(game==null)
            game = new Game();
        return game;
    }

    public void setNewMultiplier(){
        multiplier = mr.randomMultiplier();
    }

    public void spend(double price){
        this.money-=price;
    }

    public void earn(double price){ this.money+=price; }

    public void startGame(){
        running = true;
        startTime = System.currentTimeMillis();
        Thread thread = new Thread(){
            public void run(){
                super.run();
                while(running) {
                    delay();
                    update();
                }
            }
        };
        thread.start();
    }

    public Multiplier getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(Multiplier multiplier) {
        this.multiplier = multiplier;
    }

    public void update(){
        money+=calculateNetBoon();
    }

    public void resetGame(){

    }

    public boolean hasMultiplier(){
        if(multiplier!=null)
            return true;
        return false;
    }

//    public double calculateNetBoon(){
//        double netBoon = mc.calculateBoon(getGameTime(),layers) * getMultiplierValue();
//        return netBoon;
//    }

    public double calculateNetBoon(){
        double netBoon = mc.calculateBoon(System.currentTimeMillis(),layerManagers) * getMultiplierValue();
        return netBoon;
    }

    public double getMultiplierValue(){
        this.updateMultiplier();
        if(multiplier == null)
            return 1;
        return multiplier.getMultiply();
    }

    public void updateMultiplier(){
        if(multiplier == null)
            return;
        if(multiplier.startTime+multiplier.duration < System.currentTimeMillis())
            multiplier = null;
    }

    public int getGameTime(){
        return (int) (System.currentTimeMillis() - startTime);
    }

    public List<LayerManager> getLayerManagers(){
        return layerManagers;
    }

    public List<Map> getMaps(){return maps;}

    public double getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public BoonCalculator getMc() {
        return mc;
    }

    public void setMc(BoonCalculator mc) {
        this.mc = mc;
    }

    public void delay(){
        try {
            Thread.sleep(DELAY);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}