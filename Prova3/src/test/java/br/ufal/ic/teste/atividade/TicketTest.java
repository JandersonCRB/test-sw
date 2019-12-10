package br.ufal.ic.teste.atividade;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class TicketTest {

    private Long minutesToMs(Integer minutes) {
        return (long) (minutes * 60 * 1000);
    }

    @Test void create() {
        Ticket ticket = new Ticket();
        assertNotNull(ticket);
    }

    @Test
    void validationTest() {
        Long startTime = 5000L;
        Ticket ticket=  new Ticket(2, 1, startTime, startTime + minutesToMs(1), startTime + minutesToMs(7));
        assertFalse(ticket.isValid());
        assertThat(ticket.isValid(), is(false));
        ticket.setDispatchTime(minutesToMs(0));
        ticket.setKitchenTime(minutesToMs(0));
        ticket.setPhoneTime(minutesToMs(0));
        assertThat(ticket.isValid(), is(true));
    }

    /*
        Should not accept negative timings
     */
    @Test
    void wrongOrderTimings() {
        Long startTime = 5000L;
        assertThrows(Exception.class, () -> {
            Ticket ticket=  new Ticket(2, 1, startTime, startTime - minutesToMs(1), startTime - minutesToMs(7));
        });
    }
}