package praktikum.demo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static void homeMenu(Scanner in) {
        System.out.println("=== Food Ordering System ===");
        System.out.print("Enter Customer Name: ");
        String name = in.nextLine();
        System.out.print("Enter Customer Code: ");
        String code = in.nextLine();
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
        System.out.print("Select type ID: ");
        String typeId = in.nextLine();
        typeId = typeId.toLowerCase();
        System.out.println("Selected data type for ID: "+typeId);
        switch (typeId) {
            case "integer":
                System.out.print("Enter Customer ID: ");
                int idI = in.nextInt();
                in.nextLine();
                FoodOrder<Integer> foodOrderI = new FoodOrder<>(name,idI,code,menuName,fc);
                System.out.println("\nSuccessfully add data with integer ID\n");
                printData(foodOrderI);
                break;
            case "string":
                System.out.print("Enter Customer ID: ");
                String idS = in.nextLine();
                FoodOrder<String> foodOrderS = new FoodOrder<>(name,idS,code,menuName,fc);
                System.out.println("\nSuccessfully add data with string ID\n");
                printData(foodOrderS);
                break;
            default:
                throw new IllegalArgumentException("Invalid type data of ID");
        }

    }

    static void printData(FoodOrder<?> foodOrder) {
        System.out.println("===== Order Information =====");
        System.out.println("Oder Code\t\t\t: "+ foodOrder.getCode());
        System.out.println("Customer Name\t\t: "+foodOrder.getName());
        System.out.println("Customer ID\t\t\t: "+foodOrder.getId());
        System.out.println("Customer ID Type\t: "+foodOrder.getId().getClass().getSimpleName());
        System.out.println("Menu Name\t\t\t: "+foodOrder.getMenuName());
        System.out.println("Food Category\t\t: "+ foodOrder.getFoodCategory());
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try {
            homeMenu(in);
        } catch (InputMismatchException | IllegalArgumentException e) {
            System.out.println("ERROR: "+e.getMessage());
        }
    }
}

