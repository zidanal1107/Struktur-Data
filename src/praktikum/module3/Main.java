package praktikum.module3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Queue<String> ticketQueue = new LinkedList<>();
        ticketQueue.add("Andi");
        ticketQueue.add("Titan");
        ticketQueue.add("Rapi");

        System.out.println("Antrean Pelanggan Ticket Awal:");
        System.out.println(ticketQueue);

        String servedCustomer = ticketQueue.poll();
        System.out.println("Antrean setelah pelayanan:");
        System.out.println(ticketQueue);

        String nextCustomer = ticketQueue.peek();
        System.out.println("Pelanggan berikutnya yang akan dilayani: " +nextCustomer);

        Stack<String> transactionHistory = new Stack<>();
        transactionHistory.push("Ticket-Transaction-1");
        transactionHistory.push("Ticket-Transaction-2");
        transactionHistory.push("Ticket-Transaction-3");

        System.out.println();
        System.out.println("Riwayat Transaksi Tiket:");
        System.out.println(transactionHistory);

        String lastTransaction = transactionHistory.pop();
        System.out.println("Membatalkan transaksi terakhir: "+ lastTransaction);

        System.out.println("Riwayat Transaksi tiket setelah pembatalan:");
        System.out.println(transactionHistory);

        String topTransaction = transactionHistory.peek();
        System.out.println("Transaksi terakhir saat ini: "+ topTransaction);

        if (transactionHistory.isEmpty()) {
            System.out.println("Tidak ada riwayat transaksi tiket");
        } else {
            System.out.println("Riwaya transaksi tiket tidak kosong. Jumlah: "+ transactionHistory.size());
        }
    }
}
