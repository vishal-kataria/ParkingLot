package respositiories;

import models.Gate;
import models.Operator;
import models.Vehicle;

import java.util.Date;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class VehicleRepository {

    private long lastsavedid=0;
    private Map<String, Vehicle> vehicleMap = new TreeMap<>();
    public Optional<Vehicle> findVehicleByNumber(String Number){

        if(vehicleMap.containsKey(Number)){
            return Optional.of(vehicleMap.get(Number));
        }
        return Optional.empty();
    }

    public Vehicle save(Vehicle vehicle){
        Vehicle vehicleS = new Vehicle();
        vehicleS.setVehicleType(vehicle.getVehicleType());
        vehicleS.setVehicleNumber(vehicle.getVehicleNumber());
        vehicleS.setId(lastsavedid);
        vehicleS.setCreatedAt(new Date());
        vehicleS.setLastUpdatedAt(new Date());
        lastsavedid+=1;
        vehicleMap.put(vehicle.getVehicleNumber(),vehicleS);
        return vehicleS;
    }
}
