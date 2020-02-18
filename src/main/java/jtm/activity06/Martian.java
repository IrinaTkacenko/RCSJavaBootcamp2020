package jtm.activity06;

public class Martian implements Humanoid, Alien, Cloneable {

    private int weight;
    private Object backpack = new Object();

    public Martian(int initialWeight) {
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
    public void eatHuman(Humanoid humanoid) {
        if(humanoid.isAlive().equals("Alive")) {
            humanoid.killHimself();
            weight +=humanoid.getWeight();
        }
    }

    @Override
    public int getLegCount() {
        return LEG_COUNT;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return clone(this);
    }

    protected Object clone(Martian object){
        Martian cloneOfMartian = new Martian(object.getWeight());
        cloneOfMartian.setBackpack(object.getBackpack());
        return cloneOfMartian;
    }

    @Override
    public Object getBackpack(){
        if(backpack instanceof Alien) {
            Martian newMartian = (Martian)backpack;
            try {
                return newMartian.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }else if(backpack instanceof Humanoid) {
            Human human = new Human();
            human.setWeight(((Human) backpack).getWeight());
            human.setBackpack(((Human) backpack).getBackpack());
            return human;
        }else if(backpack instanceof String) {
            return new String((String)backpack);
        }
        return null;
    }

    @Override
    public void setBackpack(Object item) {
        if(item instanceof Humanoid && this != item) {
            backpack = item;
        }
    }

    @Override
    public void setBackpack(String item) {
        backpack = item;
    }

    @Override
    public String killHimself() {
        return "I AM IMMORTAL!";
    }

    @Override
    public String isAlive() {
        return killHimself();
    }

    @Override
    public int getArmCount() {
        return ARM_COUNT;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": " + weight + " [" + getBackpack() + "]";
    }
}
