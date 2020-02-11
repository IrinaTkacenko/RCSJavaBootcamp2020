package jtm.activity05;

import jtm.activity04.Road;
import jtm.activity04.Transport;

import java.util.Locale;

public class Vehicle extends Transport {
    protected int numberOfWheels;

    public Vehicle(String id, float consumption, int tankSize, int wheels) {
        super(id, consumption, tankSize);
        numberOfWheels = wheels;
    }

    @Override
    public String move(Road road) {
        String message = "";
        float neededFuel = getConsumption()/100 * road.getDistance();
        if(road.getClass() == Road.class) {
            if(getFuelInTank() >= neededFuel) {
                setFuelInTank(getFuelInTank() - neededFuel);
                message = getType() + " is driving on " + road.toString() + " with " + numberOfWheels + " wheels";
            }else {
                message = "Cannot move on " + road.toString() + ". Necessary fuel:" +
                        String.format(Locale.US, "%.2f", neededFuel) +
                        "l, fuel in tank:" + String.format(Locale.US, "%.2f", getFuelInTank()) +"l";
            }
        }else {
            message = "Cannot drive on " + road.toString();
        }
        return message;
    }



}
