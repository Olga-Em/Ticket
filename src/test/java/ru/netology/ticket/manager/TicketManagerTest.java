package ru.netology.ticket.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.ticket.Ticket;
import ru.netology.ticket.repository.TicketRepository;

public class TicketManagerTest {

    TicketRepository repo = new TicketRepository();
    TicketManager manager = new TicketManager(repo);

    Ticket ticket1 = new Ticket(1, 1500, "NSK", "IRK");
    Ticket ticket2 = new Ticket(2, 500, "NSK", "IRK");
    Ticket ticket3 = new Ticket(3, 1500, "NSK", "VLD");
    Ticket ticket4 = new Ticket(4, 2000, "NSK", "VLD");
    Ticket ticket5 = new Ticket(5, 3000, "MSK", "VLD");
    Ticket ticket6 = new Ticket(6, 5000, "MSK", "NSK");
    Ticket ticket7 = new Ticket(7, 800, "NSK", "IRK");
    Ticket ticket8 = new Ticket(8, 9000, "NSK", "IRK");
    Ticket ticket9 = new Ticket(9, 5000, "MSK", "NSK");

    @Test
    public void testSamePriceTickets() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);

        Ticket[] expected = {ticket6, ticket9};
        Ticket[] actual = manager.findAll("MSK", "NSK");

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void testSortTickets() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {ticket2, ticket7, ticket1, ticket8};
        Ticket[] actual = manager.findAll("NSK", "IRK");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testNotFoundTickets() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("NSK", "SPB");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testOneTickets() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {ticket5};
        Ticket[] actual = manager.findAll("MSK", "VLD");

        Assertions.assertArrayEquals(expected, actual);
    }
}
