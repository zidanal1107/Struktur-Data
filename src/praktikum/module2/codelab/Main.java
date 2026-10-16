package praktikum.module2.codelab;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> tickets = new ArrayList<>();

        tickets.add("T001");
        tickets.add("T002");
        tickets.add("T003");
        tickets.add("T004");

        System.out.println("=== TRAIN TICKET ARRAYLIST ===");
        System.out.println("Ticket list: "+tickets);

        System.out.println("First ticket: "+tickets.get(0));

        tickets.add(0,"T000-PRIORITY");
        System.out.println("After adding priority ticket: "+tickets);

        tickets.set(1,"T000-UPDATED");
        System.out.println("After updating T001: "+tickets);

        tickets.remove("T002");
        System.out.println("After removing T002: "+tickets);

        System.out.println("Number of tickets: "+tickets.size());

        System.out.println("Is the list empty after clear: "+tickets.isEmpty());

        tickets.clear();
        System.out.println("After clear: "+tickets);
        System.out.println("Is the list empty after clear: "+tickets.isEmpty());

        LinkedList<String> queue = new LinkedList<>();
        queue.add("GA031");
        queue.add("GA037");
        queue.add("GA042");

        System.out.println("\n=== AIRPLANE TICKET LINKEDLIST QUEUE ===");
        System.out.println("Initial queue: "+queue);

        queue.addFirst("GA045-PRIORITY");
        System.out.println("After adding a ticket at the beginning: "+queue);

        queue.addLast("GA048");
        System.out.println("After adding a ticket at the end: "+queue);

        System.out.println("First ticket (HEAD): "+queue.getFirst());

        System.out.println("Last ticket (TAIL): "+queue.getLast());

        queue.removeFirst();
        System.out.println("After serving the first customer: "+queue);

        System.out.println("Number of tickets in queue: "+queue.size());
    }
}
