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
        if(road.getClass() == Road.class) {
            float neededFuel = getConsumption()/100 * road.getDistance();
            if(getFuelInTank() >= neededFuel) {
                setFuelInTank(getFuelInTank() - neededFuel);
                return getType() + " is driving on " + road.toString() + " with " + numberOfWheels + " wheels";
            }else {
                return "Cannot move on " + road.toString() + ". Necessary fuel:" +
                        String.format(Locale.US, "%.2f", neededFuel) +
                        "l, fuel in tank:" + String.format(Locale.US, "%.2f", getFuelInTank()) +"l";
            }
        }else {
            return "Cannot drive on " + road.toString();
        }
    }


//    @Override
//    public String move(Road road) {
//        if(road.getClass() == Road.class) {
//            return super.move(road) + " with " + numberOfWheels + " wheels";
//        }else {
//            return "Cannot drive on " + road.toString();
//        }
//    }
}
