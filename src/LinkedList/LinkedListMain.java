package LinkedList;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class MyLinkedList {
    Node head;
    Node tail;
    int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head=tail=newNode;
        } else {
            tail.next=newNode;
            tail=newNode;
        }
        size++;
    }

    public void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data+" ");
            current = current.next;
        }
        System.out.println("\nLinked list size: "+size);
    }
}

public class LinkedListMain {
    public static void main(String[] args) {
        MyLinkedList li = new MyLinkedList();

        li.addLast(1);
        li.addLast(2);
        li.addLast(3);
        li.print();
    }
}
