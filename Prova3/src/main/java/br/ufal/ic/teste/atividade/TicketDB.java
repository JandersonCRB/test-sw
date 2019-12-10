package br.ufal.ic.teste.atividade;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.Getter;

/**
 *
 * @author willy
 */
public class TicketDB {
    
    @Getter
    private final int work_shift;
    
    private final Map<Integer, Ticket> ticketsById      = new HashMap<>();
    private final Map<Integer, Ticket> ticketsByNumber  = new HashMap<>();
    private final Map<String, Ticket> ticketsByCep      = new HashMap<>();

    public TicketDB(int work_shift) {
        this.work_shift = work_shift;
    }

    public void update(Ticket t) {
        ticketsById.put(t.getEcleticaId(), t);
        ticketsByNumber.put(t.getNumber(), t);
        ticketsByCep.put(t.getAddress().getCep(), t);
    }

    public List<Ticket> getTickets() {
        
        return ticketsByNumber.values().stream()
                .sorted((t1, t2) -> Integer.compare(t1.getNumber(), t2.getNumber()))
                .collect(Collectors.toList());
    }
    
    public Ticket byId(int id) {
        return ticketsById.get(id);
    }

    public Ticket byNumber(int number) {
        return ticketsByNumber.get(number);
    }

    public Address getAddress(String name, String phone, String cep) {
        Ticket ticket = ticketsByCep.get(phone);
        
        if (ticket == null) {
            
            CEPClient client = new CEPClient();
            Address address = new Address(cep);
            
            client.cepWebBuscar(address);
        }
        
        return ticket.getAddress();
    }

    public int size() {
        return ticketsById.size();
    }
}
