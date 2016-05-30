package xyz.wit543.wit.tumboon.model;
/**
 * Created by WIT on 21-May-16.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import xyz.wit543.wit.tumboon.model.util.BoonCalculator;
import xyz.wit543.wit.tumboon.model.util.MultiplierRandomizer;
public class Game extends Observable {
    private static Game game;
    private List<LayerManager> layerManagers;
    private List<Map> maps;
    private List<Upgrade> upgrades;
    private double totalMoney;
    private double money;
    private double totalFollower;
    private double follower;
    private double totalDisciple;
    private double disciple;
    private boolean running;
    private long startTime;
    private Multiplier currentMultiplier;
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
        upgrades.add(new Upgrade("car","BMW",0,false,1000));
        upgrades.add(new Upgrade("water","klong",0,false,2000));
        upgrades.add(new Upgrade("house","dogdog",0,false,4000));
        currentMultiplier = new Multiplier("FUCK",System.currentTimeMillis(),100000,4);
        money = 1000;
    }
    public static Game getInstance(){
        if(game==null)
            game = new Game();
        return game;
    }
    public List<Upgrade> getUpgrades(){return upgrades;}
    public void setNewMultiplier(){
        currentMultiplier = mr.randomMultiplier();
    }
    public void spend(double price){
        this.money-=price;
    }
    public void earn(double price){
        this.money+=price;
        this.totalMoney+=price;
    }
    public void sacrificeFollower(int amount){
        this.follower-=amount;
    }
    public void earnFollower(int amount){
        this.follower+=amount;
        this.totalFollower+=amount;
        notifyObservers();
        setChanged();
    }
    public void sacrificeDisciple(int amount){
        this.disciple-=amount;
    }
    public void earnDisciple(int amount){
        this.disciple+=amount;
        this.totalDisciple+=amount;
    }
    public double getFollower() {
        return follower;
    }
    public void setFollower(double follower) {
        this.follower = follower;
    }
    public double getTotalFollower(){
        return totalFollower;
    }
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

    public Multiplier getCurrentMultiplier() {
        return currentMultiplier;
    }
    public void setCurrentMultiplier(Multiplier currentMultiplier) {
        this.currentMultiplier = currentMultiplier;
    }
    public void update(){
        money+=calculateNetBoon();
    }
    public void resetGame(){
    }
    public boolean hasMultiplier(){
        if(currentMultiplier !=null)
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
        if(currentMultiplier == null)
            return 1;
        return currentMultiplier.getMultiply();
    }
    public void updateMultiplier(){
        if(currentMultiplier == null)
            return;
        if(currentMultiplier.startTime+ currentMultiplier.duration < System.currentTimeMillis())
            currentMultiplier = null;
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