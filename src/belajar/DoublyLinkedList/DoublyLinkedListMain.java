package belajar.DoublyLinkedList;

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
            head = tail = newNode;
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
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void printForward() {
        if (isEmpty())
            throw new RuntimeException("Linked list is empty");
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void printBackward() {
        if (isEmpty())
            throw new RuntimeException("Linked list is empty");
        Node current = tail;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.prev;
        }
        System.out.println();
    }

    public void removeFirst() {
        if (isEmpty())
            throw new RuntimeException("Linked list is empty");
        if (head == tail) {
            head = null;
            tail = null;
            size--;
            return;
        }
        head = head.next;
        head.prev = null;
        size--;
    }

    public void removeLast() {
        if (isEmpty())
            throw new RuntimeException("Linked list is empty");
        if (head == tail) {
            head = null;
            tail = null;
            size--;
            return;
        }
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

    public boolean contains(int data) {
        if (isEmpty())
            throw new RuntimeException("Array is empty");
        Node current = head;
        while (current != null) {
            if (current.data == data)
                return true;
            current = current.next;
        }
        return false;
    }

    public int indexOf(int data) {
        if (isEmpty())
            throw new RuntimeException("Array is empty");
        Node current = head;
        int i = 0;
        while (current != null) {
            if (current.data == data)
                return i;
            i++;
            current = current.next;
        }
        return -1;
    }

    public int get(int index) {
        if (isEmpty())
            throw new RuntimeException("Array is empty");
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException("Invalid index");
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    public void set(int index, int data) {
        if (isEmpty())
            throw new RuntimeException("Array is empty");
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException("Invalid index");
        Node current = head;
        int i = -1;
        while (current != null) {
            i++;
            if (index == i) {
                current.data = data;
                return;
            }
            current = current.next;
        }
    }

    public void insert(int index, int data) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException("Invalid index");
        Node newNode = new Node(data);
        if (index == 0 || isEmpty()) {
            addFirst(data);
            return;
        } else if (index == size) {
            addLast(data);
            return;
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        newNode.next = current;
        newNode.prev = current.prev;
        current.prev.next = newNode;
        current.prev = newNode;
        size++;
    }

    public void remove(int index) {
        if (isEmpty())
            throw new RuntimeException("Array is empty");
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException("Invalid index");
        if (index == size - 1) {
            removeLast();
            return;
        } else if (index == 0) {
            removeFirst();
            return;
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.prev.next = current.next;
        current.next.prev = current.prev;
        current.next = null;
        current.prev = null;
        size--;
    }

    public void clear() {
        tail = null;
        head = null;
        size = 0;
    }

    public void reverse() {
        if (isEmpty())
            throw new RuntimeException("Array is empty");
        Node current = head;
        Node temp = null;
        while (current != null) {
            temp = current.next;
            current.next = current.prev;
            current.prev = temp;
            current = current.prev;
        }
        Node old = head;
        head = tail;
        tail = old;
    }
}

public class DoublyLinkedListMain {
    public static void main(String[] args) {
        MyDoublyLinkedList li = new MyDoublyLinkedList();

        try {
//            li.addFirst(10);
//            li.addFirst(20);
            li.addFirst(30);
            li.addLast(40);
//            li.addLast(50);

//            li.removeFirst();
//            li.removeLast();
//            li.remove(3);

            li.insert(1, 67);
            li.printForward();
            li.reverse();
            li.printForward();
//            li.set(1,99);
            li.clear();
            li.printBackward();

//            System.out.println(li.getFirst());
//            System.out.println(li.getLast());
            System.out.println(li.size);
//            System.out.println(li.contains(99));
//            System.out.println(li.indexOf(10));
//            System.out.println(li.get(1));
        } catch (IndexOutOfBoundsException ie) {
            System.out.println(ie.getMessage());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
