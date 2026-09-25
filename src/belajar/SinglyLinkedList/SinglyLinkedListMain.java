package belajar.SinglyLinkedList;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class MySinglyLinkedList {
    Node head;
    Node tail;
    int size;

    public MySinglyLinkedList() {
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

    public void removeLast() {
        if (isEmpty())
            throw new RuntimeException("Linked list is empty");
        if (head == tail) {
            head = tail = null;
        } else {
            Node current = head;
            while (current.next != tail) {
                current = current.next;
            }
            current.next = null;
            tail=current;
        }
        size--;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public int get(int index) {
        if (isEmpty())
            throw new RuntimeException("Linked list is empty");
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Invalid index");
        Node current = head;
        for (int i = 0;i < index;i++) {
            current = current.next;
        }
        return current.data;
    }

    public void set(int index, int data) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Invalid index");
        Node current = head;
        for (int i = 0;i < index;i++) {
            current = current.next;
        }
        current.data = data;
    }
}

public class SinglyLinkedListMain {
    public static void main(String[] args) {
        MySinglyLinkedList li = new MySinglyLinkedList();

        try {
            li.addLast(1);
            li.addLast(2);

            li.addFirst(3);
            li.addFirst(4);

//            li.removeFirst();
            li.removeLast();

            li.addLast(5);

//            li.clear();

            li.set(0,20);

            li.print();

            System.out.println(li.contains(4));
            System.out.println(li.getFirst());
            System.out.println(li.getLast());
            System.out.println(li.get(2));

        } catch (IndexOutOfBoundsException ie) {
            System.out.println(ie.getMessage());
        } catch (RuntimeException re) {
            System.out.println(re.getMessage());
        }
    }
}
