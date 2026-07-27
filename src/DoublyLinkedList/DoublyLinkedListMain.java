package DoublyLinkedList;

class Node {
    int data;
    Node next;
    Node prev;

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class MyDoublyLinkedList {
    Node head;
    Node tail;
    int size;

    public MyDoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head=tail=newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head=tail=newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail=newNode;
        }
        size++;
    }

    public void printForward() {
        Node current = head;
        for (int i = 0;i < size;i++) {
            System.out.print(current.data+" ");
            current = current.next;
        }
        System.out.println();
    }

    public void printBackward() {
        Node current = tail;
        for (int i = size;i > 0;i--) {
            System.out.print(current.data+" ");
            current = current.prev;
        }
        System.out.println();
    }

    public void removeFirst() {
        head = head.next;
        head.prev = null;
        size--;
    }

    public void removeLast() {
        tail = tail.prev;
        tail.next = null;
        size--;
    }

    public int getFirst() {
        if (isEmpty())
            throw new RuntimeException("Array is empty");
        return head.data;
    }

    public int getLast() {
        if (isEmpty())
            throw new RuntimeException("Array is empty");
        return tail.data;
    }
}

public class DoublyLinkedListMain {
    public static void main(String[] args) {
        MyDoublyLinkedList li = new MyDoublyLinkedList();

        try {
            li.addFirst(10);
            li.addFirst(20);
            li.addFirst(30);
            li.addLast(40);
            li.addLast(50);

            li.removeFirst();
            li.removeLast();

            li.printForward();
            li.printBackward();

            System.out.println(li.getFirst());
            System.out.println(li.getLast());
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
