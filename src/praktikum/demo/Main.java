package praktikum.demo;

import praktikum.demo.Controllers.ControllerMenu;
import praktikum.demo.Controllers.OrderManager;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static boolean mainMenu(Scanner in, ControllerMenu menu, OrderManager orderManager) {
        System.out.println("=== Food Ordering System ===");
        System.out.println("1. Add Customer Order\n2. Display Active Orders\n3. Display Order Queue\n4. Process Next Order" +
                "\n5. Undo Last Transaction\n6. Display Transaction History\n7. Remove Order\n8. Exit");
        System.out.print("Choose menu: ");
        int choice = in.nextInt();
        in.nextLine();

        switch (choice) {
            case 1 -> menu.homeMenu(in, orderManager);
            case 2 -> orderManager.display();
            case 3 -> orderManager.displayQueue();
            case 4 -> orderManager.processOrder();
            case 5 -> orderManager.undoTransaction();
            case 6 -> orderManager.transactionHistory();
            case 7 -> orderManager.remove(in);
            case 8 -> {
                return false;
            }
            default -> System.out.println("\nInvalid choice\n");
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        OrderManager orderManager = new OrderManager();
        ControllerMenu controllerMenu = new ControllerMenu();
        boolean isRun = true;
        do {
            try {
                isRun = mainMenu(in, controllerMenu, orderManager);
            } catch (InputMismatchException | IllegalArgumentException | IndexOutOfBoundsException e) {
                System.out.println("\nERROR: " + e.getMessage() + "\n");
                in.nextLine();
            }
        } while (isRun);
        in.close();
    }
}

