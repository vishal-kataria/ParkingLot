package strategies.SpotAssignmentStrategy;

import models.*;

import java.util.Optional;

public interface SpotAssignmentStrategy {
    public Optional<ParkingSpot> findSpot(VehicleType vehicleType, Gate gate, ParkingLot parkingLot);
}
