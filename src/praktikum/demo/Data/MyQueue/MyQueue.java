package praktikum.demo.Data.MyQueue;
import praktikum.demo.Data.MyLinkedList.MyLinkedList;
import praktikum.demo.Services.FoodOrder;

public class MyQueue<T> {
    private MyLinkedList<T> linkedList;

    public MyQueue() {
        this.linkedList = new MyLinkedList<>();
    }

    public boolean isEmpty() {
        return linkedList.isEmpty();
    }
    public int size() {
        return linkedList.size();
    }

    public void enqueue(T data) {
        linkedList.addNormalPassenger(data);
    }
    public T dequeue() {
        if (isEmpty())
            throw new IndexOutOfBoundsException("Queue is empty");
        T data = linkedList.findData(0);
        linkedList.remove(0);
        return data;
    }
    public void display() {
        if (isEmpty())
            throw new IndexOutOfBoundsException("Queue is empty");
        linkedList.dispaly();
    }
    public T peek() {
        if (isEmpty())
            throw new IndexOutOfBoundsException("Queue is empty");
        return linkedList.findData(0);
    }
    public void clear() {
        while (!isEmpty()) {
            linkedList.remove(0);
        }
    }
    public T get(int index) {
        return linkedList.findData(index);
    }
    public static void main(String[] args) {
        MyQueue<String> queue = new MyQueue<>();
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        queue.enqueue("4");
        queue.enqueue("5");
        System.out.println(queue.size());
        queue.display();
//        queue.clear();
//        System.out.println(queue.size());
//        System.out.println(queue.isEmpty());
        System.out.println(queue.peek());
        System.out.println(queue.dequeue());
        System.out.println(queue.peek());
        queue.display();
    }
}
