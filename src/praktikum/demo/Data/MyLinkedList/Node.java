package praktikum.demo.Data.LinkedList;

public class Node<T> {
    private T data;
    private Node next;
    private Node prev;

    public Node(T data) {
        this.data=data;
        next=null;
        prev=null;
    }

    public T getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }
}
