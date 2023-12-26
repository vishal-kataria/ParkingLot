package respositiories;

import models.Gate;
import models.Ticket;

import java.util.Map;
import java.util.TreeMap;

public class TicketRepository {

    private Map<Long, Ticket> ticketMap = new TreeMap<>();
    private long lastsavedid=0;
    public Ticket save(Ticket ticket){
        ticket.setId(lastsavedid);
        lastsavedid+=1;
        ticketMap.put(lastsavedid,ticket);
        return ticket;
    }
}
