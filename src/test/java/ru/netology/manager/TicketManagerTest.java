package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TicketManagerTest {
    private Ticket first = new Ticket(1, 3000, "LED", "DME", 60);
    private Ticket second = new Ticket(2, 2000, "LED", "DME", 180);
    private Ticket third = new Ticket(3, 4000, "KUF", "OGD", 40);
    private Ticket four = new Ticket(4, 5000, "LED", "DME", 40);
    private Ticket five= new Ticket(5, 6000, "KUF", "DME", 40);
    private Ticket six = new Ticket(6, 7000, "LED", "DME", 40);
    private Ticket seven = new Ticket(7, 8000, "LED", "DME", 40);
    private TicketRepository repository = new TicketRepository();
    private TicketManager manager = new TicketManager(repository);

    @Test
    void shouldSortTickets() {
        manager.add(first);
        manager.add(second);
        manager.add(seven);
        manager.add(four);
        manager.add(six);

        Ticket[] expected = new Ticket[]{second, first, four,six, seven};
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
    @Test
    void shouldFindTicketsZero() {

        Ticket[] expected = new Ticket[]{};
        Ticket[] actual = manager.FindAll("LED", "DME");

        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldFindTicketsOne() {
        manager.add(first);

        Ticket[] expected = new Ticket[]{first};
        Ticket[] actual = manager.FindAll("LED", "DME");

        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldFindTickets() {
        manager.add(first);
        manager.add(four);
        manager.add(six);

        Ticket[] expected = new Ticket[]{first, four, six};
        Ticket[] actual = manager.FindAll("LED", "DME");

        assertArrayEquals(expected, actual);
    }
}