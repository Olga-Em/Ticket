package ru.netology.ticket.manager;

import ru.netology.ticket.Ticket;
import ru.netology.ticket.repository.TicketRepository;

import java.util.Arrays;

public class TicketManager {
    private TicketRepository repo;

    public TicketManager(TicketRepository repo) {
        this.repo = repo;
    }

    public Ticket[] add(Ticket ticket) {
        repo.add(ticket);
        return new Ticket[0];
    }

    public Ticket[] findAll(String from, String to) {
        Ticket[] results = new Ticket[0];
        for (Ticket ticket : repo.findAll()) {
            if (matches(ticket, from, to)) {
                Ticket[] tmp = new Ticket[results.length + 1];
                for (int i = 0; i < results.length; i++) {
                    tmp[i] = results[i];
                }
                tmp[results.length] = ticket;
                results = tmp;
            }
        }
        Arrays.sort(results);
        return results;
    }

    private boolean matches(Ticket ticket, String from, String to) {
        if (ticket.getFrom().equals(from)) {
            if (ticket.getTo().equals(to)) {
                return true;
            }
        }
        return false;
    }
}
