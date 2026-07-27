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

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println("\nLinked list size: " + size);
    }

    public boolean contains(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data)
                return true;
            current = current.next;
        }
        return false;
    }

    public int getFirst() {
        if (isEmpty())
            throw new RuntimeException("Linked list is empty");
        return head.data;
    }

    public int getLast() {
        if (isEmpty())
            throw new RuntimeException("Linked list is empty");
        return tail.data;
    }

    public void removeFirst() {
        if (isEmpty())
            throw new RuntimeException("Linked list is empty");
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
        }
        size--;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }
}

public class LinkedListMain {
    public static void main(String[] args) {
        MyLinkedList li = new MyLinkedList();

        try {
            li.addLast(1);
            li.addLast(2);

            li.addFirst(3);
            li.addFirst(4);

            li.removeFirst();

            li.addLast(5);

            li.clear();

            li.print();

            System.out.println(li.contains(4));
            System.out.println(li.getFirst());
            System.out.println(li.getLast());
        } catch (RuntimeException re) {
            System.out.println(re.getMessage());
        }
    }
}
