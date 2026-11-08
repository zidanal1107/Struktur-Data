package praktikum.demo.Data.MyStack;

import praktikum.demo.Data.MyLinkedList.MyLinkedList;

public class MyStack<T> {
    private MyLinkedList<T> linkedList;

    public MyStack() {
        this.linkedList = new MyLinkedList<>();
    }

    public boolean isEmpty() {
        return linkedList.isEmpty();
    }
    public int size() {
        return linkedList.size();
    }
    public void push(T data) {
        linkedList.addFirst(data);
    }
    public T pop() {
        if (isEmpty())
            throw new IndexOutOfBoundsException("Stack is empty");
        T data = linkedList.findData(0);
        linkedList.remove(0);
        return data;
    }
    public T peek() {
        if (isEmpty())
            throw new IndexOutOfBoundsException("Stack is empty");
        return linkedList.findData(0);
    }
    public void display() {
        if (isEmpty())
            throw new IndexOutOfBoundsException("Stack is empty");
        linkedList.dispaly();
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
        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
//        stack.push(2);
//        stack.push(3);
//        stack.push(4);
//        stack.push(5);
//        stack.display();
//        System.out.println(stack.size());
//        System.out.println(stack.peek());
        System.out.println(stack.pop());
        stack.display();
//        stack.clear();
//        System.out.println(stack.isEmpty());
//        System.out.println(stack.size());

    }
}
