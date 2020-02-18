package jtm.activity06;

import java.util.ArrayList;

public class Human implements Humanoid{

    private int weight;
    private String backpack;
    private boolean alive = true;

    public Human() {
        setWeight(42);
    }

    public Human(int initialWeight) {
        weight = initialWeight;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String killHimself() {
        alive = false;
        return "Dead";
    }

    @Override
    public int getArmCount() {
        return ARM_COUNT;
    }

    @Override
    public String getBackpack() {
        return backpack;
    }

    @Override
    public void setBackpack(String item) {
        backpack = item;
    }

    @Override
    public String isAlive() {
        return alive ? "Alive": "Dead";
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": " + weight + " " + getBackpack();
    }
}
