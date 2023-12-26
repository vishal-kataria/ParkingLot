import controller.TicketController;
import respositiories.GateRepository;
import respositiories.ParkingLotRepository;
import respositiories.TicketRepository;
import respositiories.VehicleRepository;
import services.TicketService;
import strategies.SpotAssignmentStrategy.RandomSpotAssignmentStrategy;
import strategies.SpotAssignmentStrategy.SpotAssignmentStrategy;

public class ParkingLotApplication {
    public static void main(String[] args) {
        GateRepository gateRepository = new GateRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        TicketRepository ticketRepository = new TicketRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();
        SpotAssignmentStrategy spotAssignmentStrategy = new RandomSpotAssignmentStrategy();

        TicketService ticketService=new TicketService(gateRepository,
                vehicleRepository,spotAssignmentStrategy,ticketRepository,
                parkingLotRepository);


        TicketController ticketController = new TicketController(ticketService);

        System.out.println("Application has started");

    }
}
