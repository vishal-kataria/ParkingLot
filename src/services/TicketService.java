package services;

import exceptions.InvalidGateException;
import exceptions.ParkingLotFull;
import models.*;
import models.Vehicle;
import models.VehicleType;
import respositiories.*;
import strategies.SpotAssignmentStrategy.SpotAssignmentStrategy;

import java.util.Date;
import java.util.Optional;

public class TicketService {

    private IGateRepository gateRepository;
    private VehicleRepository vehicleRepository;

    private SpotAssignmentStrategy spotAssignmentStrategy;

    private TicketRepository ticketRepository;

    private ParkingLotRepository parkingLotRepository;

    public TicketService(IGateRepository gateRepository,VehicleRepository vehicleRepository,SpotAssignmentStrategy spotAssignmentStrategy,TicketRepository ticketRepository,ParkingLotRepository parkingLotRepository){
        this.gateRepository = gateRepository;
        this.vehicleRepository=vehicleRepository;
        this.spotAssignmentStrategy = spotAssignmentStrategy;
        this.ticketRepository=ticketRepository;
        this.parkingLotRepository= parkingLotRepository;
    }

    /*
            gate = get gate using id -- if gate not found Raise error
            vehicle = check if exist in db or create
            operator get from gate
            parkingSpot = strategy
            we want -- ticket
         */
    public Ticket generateTicket(
            Long gateID,VehicleType vehicleType,String vehicleNumber
    ) throws InvalidGateException, ParkingLotFull {

        Optional<Gate> gateOptional = gateRepository.findGateById(gateID);
        if(gateOptional.isEmpty()){
            throw new InvalidGateException("Invalid Gate");
        }
        Gate gate = gateOptional.get();
        Operator operator = gate.getOperator();

        Optional<Vehicle> vehicleOptional = vehicleRepository.findVehicleByNumber(vehicleNumber);
        Vehicle vehicle;
        if(vehicleOptional.isEmpty()){
            vehicle = new Vehicle();
            vehicle.setVehicleNumber(vehicleNumber);
            vehicle.setVehicleType(vehicleType);
            vehicle = vehicleRepository.save(vehicle);
        }
        else{
            vehicle = vehicleOptional.get();
        }
        Optional<ParkingLot> optionalParkingLot = parkingLotRepository.getParkingLotOfGate(gate);
        ParkingLot parkingLot;
        if(optionalParkingLot.isEmpty()){
            return null;
        }
        else{
            parkingLot = optionalParkingLot.get();
        }
        Optional<ParkingSpot> optionalParkingSpot = spotAssignmentStrategy.findSpot(vehicleType,gate,parkingLot);
        ParkingSpot spot;
        if(optionalParkingSpot.isEmpty()){
            throw new ParkingLotFull("No Space left in Parking lot");
        }else{
            spot = optionalParkingSpot.get();
        }

        Ticket ticket = new Ticket();
        ticket.setParkingSpot(spot);
        ticket.setGate(gate);
        ticket.setOperator(operator);
        ticket.setEntryTime(new Date());
        ticket.setVehicle(vehicle);
        return ticketRepository.save(ticket);
    }
}
