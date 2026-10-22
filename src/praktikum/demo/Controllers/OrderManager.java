package praktikum.demo.Services;

import java.util.ArrayList;

public class OrderManager {
    private ArrayList<FoodOrder<?>> arrayList;

    public OrderManager() {
        arrayList = new ArrayList<>();
    }

    public void addOrder(FoodOrder<?> foodOrder) {
        arrayList.add(foodOrder);
    }

    public void addItem(String code, OrderItem item) {
        for (FoodOrder<?> order : arrayList) {
            if (order.getCode().equals(code)) {
                order.addItem(item);
                return;
            }
        }
        throw new IndexOutOfBoundsException("Code not found");
    }

    public void print() {
        System.out.println("\n=========================");
        System.out.println("=== ALL ACTIVE ORDERS ===");
        for (FoodOrder<?> order : arrayList) {
            System.out.println("=========================");
            System.out.println("Order Code\t\t: " + order.getCode());
            System.out.println("Customer Name\t: " + order.getName());
            System.out.println("Customer ID\t\t: " + order.getId());
            System.out.println("Customer ID Type: " + order.getId().getClass().getSimpleName());
            System.out.print("Ordered Items:\n");
            order.getItem();
            System.out.println("=========================");
        }
    }
}
