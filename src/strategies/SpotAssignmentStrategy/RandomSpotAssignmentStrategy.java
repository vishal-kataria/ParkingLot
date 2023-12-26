package strategies.SpotAssignmentStrategy;

import models.*;

import java.util.Optional;

public class RandomSpotAssignmentStrategy implements SpotAssignmentStrategy{

    @Override
    public Optional<ParkingSpot> findSpot(VehicleType vehicleType, Gate gate, ParkingLot parkingLot) {

        for(ParkingFloor floor: parkingLot.getParkingFloors()){
            for(ParkingSpot spot: floor.getParkingSpots()){
                if(spot.getSpotStatus().equals(ParkingSpotStatus.AVAILABLE) && spot.getSupportedVehicles().contains(vehicleType)){
                    return Optional.of(spot);
                }
            }

        }

        return Optional.empty();
    }
}
