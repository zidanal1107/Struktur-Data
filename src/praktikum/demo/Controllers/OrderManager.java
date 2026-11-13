package praktikum.demo.Controllers;

import praktikum.demo.Data.MyQueue.MyQueue;
import praktikum.demo.Data.MyStack.MyStack;
import praktikum.demo.Services.FoodOrder;
import praktikum.demo.Services.OrderItem;

import java.util.ArrayList;
import java.util.Scanner;

public class OrderManager {
    private ArrayList<FoodOrder<?>> arrayList;
    private MyQueue<FoodOrder<?>> queue;
    private MyStack<FoodOrder<?>> stack;

    public OrderManager() {
        arrayList = new ArrayList<>();
        queue = new MyQueue<>();
        stack = new MyStack<>();
    }

    public void addOrderArrayList(FoodOrder<?> foodOrder) {
        arrayList.add(foodOrder);
    }

    public void addOrderQueue(FoodOrder<?> foodOrder) {
        queue.enqueue(foodOrder);
    }

    public void addOrderStack(FoodOrder<?> foodOrder) {
        stack.push(foodOrder);
    }

    public void processOrder() {
        if (queue.isEmpty()) {
            System.out.println("\n========================");
            System.out.println("Queue is empty");
            System.out.println("========================\n");
            return;
        }
        addOrderStack(queue.peek());
        arrayList.remove(0);

        FoodOrder<?> order = queue.dequeue();
        System.out.println("\n========================");
        System.out.println("=== PROCESSING ORDER ===");
        System.out.println("Processing order: " + order.getCode());
        System.out.println("Customer\t\t: " + order.getName());
        System.out.println("\nOrder processed successfully.");
        System.out.println("========================\n");
    }

    public void transactionHistory() {
        System.out.println("\n===========================");
        System.out.println("=== TRANSACTION HISTORY ===");
        if (stack.isEmpty()) {
            System.out.println("Transaction history is empty");
            System.out.println("===========================\n");
            return;
        }
        for (int i = 0; i < stack.size(); i++) {
            FoodOrder<?> order = stack.get(i);
            System.out.println("===========================");
            System.out.println("Order Code\t\t: " + order.getCode());
            System.out.println("Customer Name\t: " + order.getName());
            System.out.println("Customer ID\t\t: " + order.getId());
            System.out.println("Customer ID Type: " + order.getId().getClass().getSimpleName());
            System.out.print("Ordered Items:\n");
            order.getItem();
            System.out.println("===========================\n");
        }
    }

    public void undoTransaction() {
        if (stack.isEmpty()) {
            System.out.println("\nNo transactions available.\n");
            return;
        }
        FoodOrder<?> order = stack.pop();
        addOrderArrayList(order);
        addOrderQueue(order);
        System.out.println("\nUndo transaction successfully.\n");
    }

    public boolean findDatas(int index) {
        return index >= 0 && index < arrayList.size();
    }

    public void remove(Scanner in) {
        if (arrayList.isEmpty()) {
            System.out.println("\nData is empty.\n");
            return;
        }
        int i=0;
        System.out.println("\n============================");
        for (FoodOrder order: arrayList) {
            i++;
            System.out.print(i+". "+order.getCode()+" - "+order.getName());
            System.out.println();
        }
        System.out.println("============================");
        System.out.print("Choose number: ");
        int index = in.nextInt();
        in.nextLine();
        index = index-1;
        FoodOrder order = arrayList.get(index);
        queue.remove(index);
        arrayList.remove(index);
        System.out.println("Deleted: Name ["+order.getName()+"] Code ["+order.getCode()+"]\n");
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

    public void display() {
        System.out.println("\n=========================");
        System.out.println("=== ALL ACTIVE ORDERS ===");
        if (arrayList.isEmpty()) {
            System.out.println("Active order is empty");
            System.out.println("=========================\n");
            return;
        }
        for (FoodOrder<?> order : arrayList) {
            System.out.println("=========================");
            System.out.println("Order Code\t\t: " + order.getCode());
            System.out.println("Customer Name\t: " + order.getName());
            System.out.println("Customer ID\t\t: " + order.getId());
            System.out.println("Customer ID Type: " + order.getId().getClass().getSimpleName());
            System.out.print("Ordered Items:\n");
            order.getItem();
            System.out.println("=========================\n");
        }
    }

    public void displayQueue() {
        System.out.println("\n===============================");
        System.out.println("=== ORDERS PROCESSING QUEUE ===");
        if (queue.isEmpty()) {
            System.out.println("Queue is empty");
            System.out.println("===============================\n");
            return;
        }
        for (int i = 0; i < queue.size(); i++) {
            FoodOrder<?> order = queue.get(i);
            System.out.println((i + 1) + ". " + order.getCode() + " - " + order.getName());
        }
        System.out.println("===============================\n");

    }
}
