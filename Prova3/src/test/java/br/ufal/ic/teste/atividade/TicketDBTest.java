package br.ufal.ic.teste.atividade;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketDBTest {

    private TicketDB ticketDB;

    @BeforeEach
    void resetDb() {
        ticketDB = new TicketDB(1);
    }

    @Test
    void shouldNotAcceptNullPrimaryKeys() {
        assertThrows(Exception.class, () -> {
            Ticket t = new Ticket();
            ticketDB.update(t);
        });
        Ticket ticket = new Ticket(2, 1, 0L, 0L, 0L);
        ticketDB.update(ticket);
    }

    @Test
    void getAddress() {
        Ticket ticket = new Ticket();
        ticketDB.update(ticket);
        Address address = ticketDB.getAddress("Janderson", "82996254970", "57010040");
    }
}