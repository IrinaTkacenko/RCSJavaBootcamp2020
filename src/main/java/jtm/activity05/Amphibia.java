package jtm.activity05;

import jtm.activity04.Road;

public class Amphibia extends Vehicle {

    private byte numberOfSails;

    public Amphibia(String id, float consumption, int tankSize, byte numberOfSails , int wheels) {
        super(id, consumption, tankSize, wheels);
        this.numberOfSails = numberOfSails;
    }

    @Override
    public String move(Road road) {
        if ((road instanceof WaterRoad)) {
            return getType() + " is sailing on " + road.toString() + " with " + numberOfSails + " sails";
        } else {
            return super.move(road);
        }
    }

//    @Override
//    public String move(Road road) {
//        String status = "";
//        if (road instanceof WaterRoad) {
//            WaterRoad waterRoad = (WaterRoad) road;
//            return getType() + " is sailing on " + road.toString() + " with " + numberOfSails + " sails";
//        }
//        if(road instanceof Road) {
//            //Road groundRoad = road;
//            return super.move(road);
//        }
//        return status;
//    }
}
