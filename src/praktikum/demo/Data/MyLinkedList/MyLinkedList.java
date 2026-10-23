package praktikum.demo.Data.MyLinkedList;

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
                System.out.println(" "+current.getData());
                current=current.getNext();
            }
            System.out.println();
        }
    }
    public void set(int index,T newData) {
        Node current=head;
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Data is empty");
        } else if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Data not found");
        } else {
            int i=-1;
            while (current != null) {
                i++;
                if (index == i) {
                    current.setData(newData);
                    return;
                }
                current=current.getNext();
            }
        }
    }
    public boolean findData(T data) {
        Node current=head;
        while (current!=null) {
            if (current==data) return true;
            current=current.getNext();
        }
        return false;
    }
    public void remove(int index) {
        Node current=head;
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Data is empty");
        } else if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Data not found");
        } else {
            int i=-1;
            while (current != null) {
                i++;
                if (index == i) {
                    if (current == head) {
                        head=current.getNext();
                        if (head != null) {
                            head.setPrev(null);
                        }
                        return;
                    } else {
                        Node next=current.getNext();
                        Node prev=current.getPrev();
                        prev.setNext(next);
                        if (next != null) {
                            next.setPrev(prev);
                        }
                        return;
                    }
                }
                current=current.getNext();
                size--;
            }
        }
    }

    public static void main(String[] args) {
        try {
//            MyLinkedList<OrderItem> linkedList = new MyLinkedList<>();
//            OrderItem orderItem1 = new OrderItem("Ayam", FoodCategory.FOOD,2);
//            OrderItem orderItem2 = new OrderItem("Ayam Geprek", FoodCategory.FOOD,1);
//            OrderItem orderItem3 = new OrderItem("Nasgor", FoodCategory.FOOD,1);
//            linkedList.addFirst(orderItem1);
//            linkedList.addFirst(orderItem2);
//            linkedList.addLast(orderItem3);
//
//            linkedList.print();
//            System.out.println(linkedList.size);
//
//            OrderItem orderItem4 = new OrderItem("Batagor", FoodCategory.FOOD,1);
//            linkedList.set(2,orderItem4);
//            linkedList.remove(1);
//            linkedList.print();
//            System.out.println(linkedList.size);

        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }
}
