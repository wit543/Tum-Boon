package xyz.wit543.wit.tumboon.model;

/**
 * Created by WIT on 21-May-16.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Game {
    private static Game game;
    private List<Layer> layers;
    private double money;
    private boolean running;
    private long startTime;
    private BoonCalculator mc;
    private Multiplier multiplier;

    private final int DELAY = 100;

    private Game(){
        mc = new BoonCalculator();
        layers = new ArrayList<Layer>();
        layers.add(new Layer("Car" , 1 , 100 , 1000));
        layers.add(new Layer("Helicopter" , 1 , 200 , 3000));
        multiplier = new Multiplier(5000,10000,4);
        money = 0;
    }

    public static Game getInstance(){
        if(game==null)
            game = new Game();
        return game;
    }

    public void startGame(){
        running = true;
        startTime = System.currentTimeMillis();
        Thread thread = new Thread(){
            public void run(){
                super.run();
                while(running) {
                    delay();
                    money+=calculateNetBoon();
                }
            }
        };
        thread.start();
    }

    public double calculateNetBoon(){
        double netBoon = mc.calculateBoon(getGameTime(),layers) * getMultiplierValue();
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
        if(multiplier.startTime+multiplier.duration < getGameTime())
            multiplier = null;
    }

    public int getGameTime(){
        return (int) (System.currentTimeMillis() - startTime);
    }

    public List<Layer> getLayers() {
        return layers;
    }

    public void setLayers(List<Layer> layers) {
        this.layers = layers;
    }

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