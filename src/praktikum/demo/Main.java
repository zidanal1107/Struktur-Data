package praktikum.demo;

import praktikum.demo.Data.MyLinkedList.Node;
import praktikum.demo.Services.FoodCategory;
import praktikum.demo.Services.FoodOrder;
import praktikum.demo.Services.OrderItem;
import praktikum.demo.Controllers.OrderManager;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static void menu(Scanner in, OrderManager orderManager) {
        homeMenu(in, orderManager);
        System.out.println("=== Find Order ===");
        System.out.print("Input index data find: ");
        int index = in.nextInt();
        in.nextLine();
        if (orderManager.findDatas(index)) {
            System.out.println("data is found");
        } else {
            System.out.println("Data not found");
        }
        System.out.println("Input index remove: ");
        int i = in.nextInt();
        in.nextLine();
        orderManager.remove(i);
        orderManager.print();
    }

    static void homeMenu(Scanner in, OrderManager orderManager) {
        char choice;
        do {
            System.out.println("=== Food Ordering System ===");
            System.out.print("Enter Customer Name: ");
            String name = in.nextLine();
            System.out.print("Enter Customer ID: ");
            String typeId = in.nextLine();
            System.out.print("Enter Customer Code: ");
            String code = in.nextLine();

            if (isLong(typeId)) {
                Long id = Long.valueOf(typeId);
                FoodOrder<Long> order = new FoodOrder<>(name,id,code);
                orderManager.addOrder(order);
                addOrderItem(in,orderManager,code);
            } else {
                String id = String.valueOf(typeId);
                FoodOrder<String> order = new FoodOrder<>(name,id,code);
                orderManager.addOrder(order);
                addOrderItem(in,orderManager,code);
            }
            System.out.print("\nAdd another customer order? (y/n): ");
            choice = in.next().charAt(0);
            in.nextLine();
        } while (choice == 'Y' || choice == 'y');
        orderManager.print();
    }

    static void addOrderItem(Scanner in,OrderManager orderManager,String code) {
        char orderAdd;
        do {
            System.out.print("Enter Menu Name: ");
            String menuName = in.nextLine();

            System.out.println("Select Food Category: ");
            System.out.println("1. FOOD\n2. BEVERAGE\n3. DESSERT");
            System.out.print("Enter choice: ");
            int choice = in.nextInt();
            in.nextLine();
            FoodCategory fc;
            switch (choice) {
                case 1:
                    fc = FoodCategory.FOOD;
                    break;
                case 2:
                    fc = FoodCategory.BEVERAGE;
                    break;
                case 3:
                    fc = FoodCategory.DESSERT;
                    break;
                default:
                    throw new IllegalArgumentException("Invalid food category");
            }
            System.out.print("Enter Quantity: ");
            int quantity = in.nextInt();
            in.nextLine();
            orderManager.addItem(code,new OrderItem(menuName,fc,quantity));
            System.out.print("Add another item to this order? (y/n): ");
            orderAdd = in.next().charAt(0);
            in.nextLine();
        } while (orderAdd == 'Y' || orderAdd == 'y');
    }

    static boolean isLong(String value) {
        try {
            Long.parseLong(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        OrderManager orderManager = new OrderManager();
        boolean isRun = true;
        try {
            do {
                menu(in,orderManager);
            } while (isRun);
        } catch (InputMismatchException | IllegalArgumentException | IndexOutOfBoundsException e) {
            System.out.println("ERROR: "+e.getMessage());
        }
    }
}

