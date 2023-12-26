package controller;

import dto.*;
import exceptions.InvalidGateException;
import exceptions.ParkingLotFull;
import models.*;
import services.TicketService;

public class TicketController {

    private TicketService ticketService;

    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }

    public GenerateTicketResponseDTO generateTicket(GenerateTicketRequestDTO requestDTO)
            {

        String vehicleNumber= requestDTO.getVehicleNumber();
        VehicleType vehicleType = requestDTO.getVehicleType();
        Long gateId = requestDTO.getGateId();
        GenerateTicketResponseDTO responseDTO = new GenerateTicketResponseDTO();
        Ticket ticket;
        try {
            ticket = ticketService.generateTicket(gateId, vehicleType, vehicleNumber);
        }
        catch (InvalidGateException | ParkingLotFull e){
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
            responseDTO.setMessage(e.getMessage());
            return responseDTO;
        }

        responseDTO.setTicketId(ticket.getId());
        responseDTO.setOperatorName(ticket.getOperator().getName());
        responseDTO.setSpotNumber(ticket.getParkingSpot().getNumber());
        responseDTO.setResponseStatus(ResponseStatus.SUCCESS);

        return responseDTO;

    }

}
