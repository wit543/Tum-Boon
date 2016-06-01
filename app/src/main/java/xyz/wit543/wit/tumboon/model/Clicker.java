package xyz.wit543.wit.tumboon.model;

import java.util.ArrayList;
import java.util.List;

import xyz.wit543.wit.tumboon.R;

/**
 * Created by Momo on 30/5/2559.
 */
public class Clicker {
    private int attack;
    private int currentPeople;
    private List<Integer> people;

    public Clicker(){
        this.attack = 10;
        currentPeople = 0;
        people = new ArrayList<Integer>();
        people.add(R.drawable.ufo_scoobydoo);
        people.add(R.drawable.ufo_steve);
        people.add(R.drawable.ufo_dexter);
    }

    public void setAttack(int attack){
        this.attack = attack;
    }

    public void randomPeople(){
        int random=0;
        do{
            random = (int)Math.floor(Math.random()*people.size());
        }while (random==currentPeople);
        currentPeople = random;
    }

    public int getCurrentPeoplePicture(){
        return people.get(currentPeople);
    }

    public int getAttack(){
        return attack;
    }
}