package ru.netology.ticket.repository;

import ru.netology.ticket.Ticket;

public class TicketRepository {

    private Ticket[] tickets = new Ticket[0];

    public Ticket[] add(Ticket prod) {
        Ticket[] tmp = new Ticket[tickets.length + 1];
        for (int i = 0; i < tickets.length; i++) {
            tmp[i] = tickets[i];
        }
        tmp[tmp.length - 1] = prod;
        tickets = tmp;
        return tmp;
    }

//    public Ticket[] removerById(int idRemove) {
//        Ticket[] tmp = new Ticket[tickets.length - 1];
//        int copyToIndex = 0;
//        for (Ticket prod : tickets) {
//            if (prod.getId() != idRemove) {
//                tmp[copyToIndex] = prod;
//                copyToIndex++;
//            }
//        }
//        tickets = tmp;
//        return tmp;
//    }
//
//    public Ticket findById(int id) {
//        for (Ticket product : tickets) {
//            if (product.getId() == id) {
//                return product;
//            }
//        }
//        return null;
//    }

    public Ticket[] findAll() {
        return tickets;
    }
}
