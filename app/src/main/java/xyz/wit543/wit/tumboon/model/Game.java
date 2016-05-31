package xyz.wit543.wit.tumboon.model;

/**
 * Created by WIT on 21-May-16.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import xyz.wit543.wit.tumboon.model.factory.FactoryProducer;
import xyz.wit543.wit.tumboon.model.factory.LayerAbstractFactory;
import xyz.wit543.wit.tumboon.model.util.BoonCalculator;
import xyz.wit543.wit.tumboon.model.util.MultiplierRandomizer;

public class Game extends Observable{
    private static Game game;
    private MapConstant map = MapConstant.WAT;

    private List<LayerManager> layerManagers;
    private List<Map> maps;
    private List<Upgrade> upgrades;
    private List<Multiplier> multipliers;

    private double totalMoney;
    private double money;
    private int totalFollower;
    private int follower;
    private int totalDisciple;
    private int disciple;
    private int rebirthCount;

    private boolean running;
    private long startTime;
    private Multiplier currentMultiplier;

    private BoonCalculator mc;
    private MultiplierRandomizer mr;
    private LayerAbstractFactory layerFactory;

    private final double startMoney = 1000;

    private Game(){
        this.resetGame();
    }

    public void defineEnvironment(){
        layerFactory = FactoryProducer.getFactory(map);

        multipliers = new ArrayList<Multiplier>();
        upgrades = new ArrayList<Upgrade>();
        layerManagers = layerFactory.getAllLayer();

        multipliers.add(new Multiplier("แสดงอภินิหาร",0,100000,4));
        multipliers.add(new Multiplier("ใบ้หวย",0,100000,2));

        upgrades.add(new Upgrade("money","BMW",1000));
        upgrades.add(new Upgrade("water","klong",2000));
        upgrades.add(new Upgrade("house","dogdog",4000));

        mc = new BoonCalculator();
        mr = new MultiplierRandomizer(multipliers);

    }

    public double getFollower() {
        return follower;
    }

    public void setFollower(int follower) {
        this.follower = follower;
    }

    public double getDisciple() {
        return disciple;
    }

    public void setDisciple(int disciple) {
        this.disciple = disciple;
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

    public void earnBoonFromClick(double amount){
        this.money+=amount;
        this.totalMoney+=amount;
        this.notifyObservers();
    }

    public void earnBoon(double amount){
        this.money+=amount;
        this.totalMoney+=amount;
    }

    public void sacrificeFollower(int amount){
        this.follower-=amount;
        this.notifyObservers();
        this.setChanged();
    }

    public void earnFollower(int amount){
        this.follower+=amount;
        this.totalFollower+=amount;
        this.notifyObservers();
        this.setChanged();
    }

    public void sacrificeDisciple(int amount){
        this.disciple-=amount;
    }

    public void earnDisciple(int amount){
        this.disciple+=amount;
        this.totalDisciple+=amount;
    }


    public void startGame(){
        running = true;
        startTime = System.currentTimeMillis();
    }

    public Multiplier getCurrentMultiplier() {
        return currentMultiplier;
    }

    public void update(){
        this.earnBoon(calculateNetBoon());
    }

    public void resetGame(){
        this.defineEnvironment();
        totalMoney=startMoney;
        money=startMoney;
        totalFollower=0;
        follower=0;
        totalDisciple=0;
        disciple=0;
        rebirthCount=0;
    }

    public void rebirth(){
        this.earnDisciple(this.follower);
        money=startMoney;
        follower=0;
        rebirthCount+=1;

        for(LayerManager layerManager : this.getLayerManagers()){
            layerManager.setLevel(0);
        }
        for(Upgrade upgrade : this.getUpgrades()){
            upgrade.setMultiplier(0);
        }
        this.notifyObservers();
        this.setChanged();
    }

    public boolean hasMultiplier(){
        if(currentMultiplier !=null)
            return true;
        return false;
    }

    public double calculateNetBoon(){
        double netBoon = mc.calculateBoon(System.currentTimeMillis(),layerManagers) * getMultiplierValue();
        netBoon += netBoon*(this.disciple/10000);
        return netBoon;
    }

    public double getMultiplierValue(){
        this.updateMultiplier();
        if(hasMultiplier())
            return currentMultiplier.getMultiply();
        return 1;
    }

    public void updateMultiplier(){
        if(currentMultiplier == null)
            return;
        if(currentMultiplier.startTime+ currentMultiplier.duration < System.currentTimeMillis())
            currentMultiplier = null;
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

    public Mememto saveState(){
        int[] layerLevel = new int[layerManagers.size()];
        int[] upgradesCount = new int[upgrades.size()];
        for(int i=0; i<layerManagers.size();i++){
            layerLevel[i] = layerManagers.get(i).getLevel();
        }
        for(int i=0; i<upgrades.size();i++){
            upgradesCount[i] = upgrades.get(i).getUpgradeCount();
        }
        return new Mememto(totalMoney,money,totalFollower,follower,totalDisciple,disciple , layerLevel,upgradesCount);
    }

    public void restore(Mememto m){
        this.totalMoney = m.totalMoney;
        this.money = m.money;
        this.totalFollower = m.totalFollower;
        this.follower = m.follower;
        this.totalDisciple = m.disciple;
        this.disciple = m.disciple;
        int[] layerLevel = m.layerLevel;
        int[] upgradeCount = m.upgradeLevel;

        if(layerLevel!=null){
            for(int i=0 ; i<layerManagers.size();i++){
                layerManagers.get(i).setLevel(layerLevel[i]);
            }
        }
        if(upgradeCount!=null){
            for(int i=0; i<upgrades.size();i++){
                for(int j=0; j<upgradeCount[i];j++){
                    upgrades.get(i).upPrice();
                }
            }
        }
    }


    public static class Mememto {
        private double totalMoney;
        private double money;
        private int totalFollower;
        private int follower;
        private int totalDisciple;
        private int disciple;
        private int[] layerLevel;
        private int[] upgradeLevel;

        private Mememto(double totalMoney ,double money ,int totalFollower ,int follower ,int totalDisciple ,int disciple ,int[] layerLevel , int[] upgradeLevel ){

            this.totalMoney = totalMoney;
            this.money = money;
            this.totalFollower =  totalFollower;
            this.follower = follower;
            this.totalDisciple = totalDisciple;
            this.disciple = disciple;
            this.layerLevel = layerLevel;
            this.upgradeLevel = upgradeLevel;
        }

    }
}