package jtm.activity05;

import jtm.activity04.Road;
import jtm.activity04.Transport;

public class Ship extends Transport {
    protected byte numberOfSails;

    public Ship(String id, byte sails) {
        super(id, 0, 0);
        numberOfSails = sails;
    }

    @Override
    public String move(Road road) {
        if(road instanceof WaterRoad) {
            return getType() + " is sailing on " + road.toString() + " with " + numberOfSails + " sails";
        }else {
            return "Cannot sail on " + road.toString();
        }
    }
}
