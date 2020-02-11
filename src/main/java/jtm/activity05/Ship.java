package jtm.activity05;

import jtm.activity04.Road;
import jtm.activity04.Transport;

public class Ship extends Transport {
    protected byte numberOfSails;

    public Ship(String id, float consumption, int tankSize) {
        super(id, consumption, tankSize);
    }

    public Ship(String id, byte sails) {
        this.setId(id);
        numberOfSails = sails;
    }

    @Override
    public String move(Road road) {
        String message = "";
        if(road instanceof WaterRoad) {
            message = getType() + " is sailing on " + road.toString() + " with " + numberOfSails + " sails";
        }else {
            message = "Cannot sail on " + road.toString();
        }
        return message;
    }
}
