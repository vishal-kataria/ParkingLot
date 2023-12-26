package respositiories;

// CRUD for gate table

import models.Gate;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class GateRepository implements  IGateRepository{

    private Map<Long,Gate> gateMap = new TreeMap<>();
    public Optional<Gate> findGateById(Long gateId){
        if(gateMap.containsKey(gateId)){
            return Optional.of(gateMap.get(gateId));
        }

        return Optional.empty();
    }
}
