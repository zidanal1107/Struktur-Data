package praktikum.module1.codelab;

public class GenericTicket<T> {
    private T ticketCode;
    private String passengerName;

    public GenericTicket(T ticketCode, String passengerName) {
        this.ticketCode = ticketCode;
        this.passengerName = passengerName;
    }

    public T getTicketCode() {
        return ticketCode;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void displayTicket() {
        System.out.println("=== Ticket Information ===");
        System.out.println("Ticket Code     : "+ticketCode);
        System.out.println("Passenger Name  : "+passengerName);
        System.out.println("Ticket Code Type: "+ticketCode.getClass().getSimpleName());
    }

    public static void main(String[] args) {
        GenericTicket<String> ticket1 = new GenericTicket<>("TK-001","Andi");
        GenericTicket<Integer> ticket2 = new GenericTicket<>(1002, "Budi");

        ticket1.displayTicket();
        System.out.println();
        ticket2.displayTicket();
    }
}
