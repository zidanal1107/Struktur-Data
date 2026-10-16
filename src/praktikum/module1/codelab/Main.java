package praktikum.module1.codelab;

public class Main {
    public static void main(String[] args) {
        GenericTicket<String> ticket1 = new GenericTicket<>("TK-001","Andi");
        GenericTicket<Integer> ticket2 = new GenericTicket<>(1002, "Budi");

        ticket1.displayTicket();
        System.out.println();
        ticket2.displayTicket();
    }
}
