package praktikum.demo.Data.LinkedList;

import praktikum.demo.Services.FoodCategory;
import praktikum.demo.Services.OrderItem;

public class MyLinkedList<T> {
    private Node head;
    private Node tail;
    private int size;

    public MyLinkedList() {
        this.head=null;
        this.tail=null;
        this.size=0;
    }
    public int size() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public void addNormalPassenger(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head=tail=newNode;
        } else {
            newNode.setPrev(tail);
            tail.setNext(newNode);
            tail=newNode;
        }
        size++;
    }
    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head=tail=newNode;
        } else {
            newNode.setNext(head);
            head.setPrev(newNode);
            head=newNode;
        }
        size++;
    }
    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head=tail=newNode;
        } else {
            newNode.setPrev(tail);
            tail.setNext(newNode);
            tail=newNode;
        }
        size++;
    }
    public void print() {
        Node current = head;
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Data is empty");
        } else {
            while (current != null) {
                System.out.print(current.getData()+" ");
                current=current.getNext();
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        MyLinkedList<OrderItem> linkedList = new MyLinkedList<>();
        OrderItem orderItem1 = new OrderItem("Ayam", FoodCategory.FOOD,2);
        OrderItem orderItem2 = new OrderItem("Ayam Geprek", FoodCategory.FOOD,1);
        OrderItem orderItem3 = new OrderItem("Nasgor", FoodCategory.FOOD,1);
        linkedList.addFirst(orderItem1);
        linkedList.addFirst(orderItem2);
        linkedList.addLast(orderItem3);

        linkedList.print();
        System.out.println(linkedList.size);
    }
}
