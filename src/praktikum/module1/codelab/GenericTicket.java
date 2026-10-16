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
}
