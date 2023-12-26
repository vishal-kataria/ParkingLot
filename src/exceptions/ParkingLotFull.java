package exceptions;

import models.ParkingSpot;

public class ParkingLotFull extends Exception {
    public ParkingLotFull(String message){
        super(message);
    }
}
