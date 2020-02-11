package jtm.activity05;

import jtm.activity04.Road;
import jtm.activity04.Transport;

import java.util.Locale;

public class Amphibia extends Transport {

    private byte numberOfSails;
    private int numberOfWheels;

    public Amphibia(String id, float consumption, int tankSize, byte sails, int wheels) {
        super(id, consumption, tankSize);
        numberOfSails = sails;
        numberOfWheels = wheels;
    }

    @Override
    public String move(Road road) {
        String message = "";
        float neededFuel = getConsumption()/100 * road.getDistance();
        if(road instanceof WaterRoad) {
            message = getType() + " is sailing on " + road.toString() + " with " + numberOfSails + " sails";
        }else {
            if(getFuelInTank() >= neededFuel) {
                setFuelInTank(getFuelInTank() - neededFuel);
                message = getType() + " is driving on " + road.toString() + " with " + numberOfWheels + " wheels";
            }else {
                message = "Cannot move on " + road.toString() + ". Necessary fuel:" +
                        String.format(Locale.US, "%.2f", neededFuel) +
                        "l, fuel in tank:" + String.format(Locale.US, "%.2f", getFuelInTank()) +"l";
            }
        }
        return message;
    }
}
