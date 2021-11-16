package ru.netology.manager;

import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

public class TicketManager {
    private final TicketRepository repository;
    public Ticket ticket;

    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }


    public void add(Ticket item) {
        repository.save(item);
    }

    public Ticket[] FindAll(String departureAirport, String arrivalAirport) {
        Ticket[] result = new Ticket[0];
        for (Ticket item : repository.findAll()) {
            if (matches(item, departureAirport, arrivalAirport)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = item;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

    public boolean matches(Ticket item, String departureAirport, String arrivalAirport) {
        if (item instanceof Ticket) {
            Ticket ticket = (Ticket) item;
            if (ticket.getDepartureAirport().contains(departureAirport)) {
                return true;
            }
            if (ticket.getArrivalAirport().contains(arrivalAirport)) {
                return true;
            }
            return false;
        }
        return false;
    }
}