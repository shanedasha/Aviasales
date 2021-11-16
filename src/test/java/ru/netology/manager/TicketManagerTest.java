package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TicketManagerTest {
    private Ticket first = new Ticket(1, 3000, "LED", "DME", 60);
    private Ticket second = new Ticket(2, 2000, "LED", "DME", 180);
    private Ticket third = new Ticket(3, 3000, "KUF", "OGD", 40);
    private TicketRepository repository = new TicketRepository();
    private TicketManager manager = new TicketManager(repository);

    @Test
    void shouldSortTickets() {
        manager.add(first);
        manager.add(second);

        Ticket[] expected = new Ticket[]{second, first};
        Ticket[] actual = manager.FindAll("LED", "DME");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindTicketsByAirport() {
        manager.add(first);
        manager.add(second);
        manager.add(third);

        Ticket[] expected = new Ticket[]{second, first};
        Ticket[] actual = manager.FindAll("LED", "DME");

        assertArrayEquals(expected, actual);
    }
}