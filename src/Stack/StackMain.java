package Stack;

class MyStack {
    int[] array;
    int top;
    int maxSize;
    int size;

    public MyStack(int maxSize) {
        this.maxSize = maxSize;
        top = -1;
        size = 0;
        array = new int[maxSize];
    }

    public void push(int data) {
        if (isFull())
            throw new RuntimeException("Stack is full");
        array[++top] = data;
        size++;
    }

    public int pop() {
        if (isEmpty())
            throw new RuntimeException("Stack is empty");
        size--;
        return array[top--];
    }

    public boolean isFull() {
        return size == maxSize;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int get(int index) {
        if (index < 0 || index > top)
            throw new IndexOutOfBoundsException("Invalid index");
        return array[index];
    }

    public void set(int index, int data) {
        if (index < 0 || index > top)
            throw new IndexOutOfBoundsException("Invalid index");
        array[index] = data;
    }

    public int peek() {
        if (isEmpty())
            throw new RuntimeException("Stack is empty");
        return array[top];
    }

    public void clear() {
        if (isEmpty())
            throw new RuntimeException("Stack is empty");
        top = -1;
        size = 0;
    }

    public boolean contains(int data) {
        if (isEmpty())
            throw new RuntimeException("Stack is empty");
        for (int i = 0; i <= top; i++) {
            if (data == array[i]) {
                return true;
            }
        }
        return false;
    }

    public int search(int data) {
        if (isEmpty())
            throw new RuntimeException("Stack is empty");
        for (int i = top; i >= 0; i--) {
            if (data == array[i]) {
                return i;
            }
        }
        return -1;
    }

    public void print() {
        if (isEmpty())
            throw new RuntimeException("Stack is empty");
        for (int i = top; i >= 0; i--)
            System.out.print(array[i] + " ");
    }
}

public class StackMain {
    public static void main(String[] args) {
        MyStack ms = new MyStack(5);

        try {
            ms.push(5);
            ms.push(10);
            ms.push(15);

            System.out.println("Result pop: " + ms.pop());

            ms.push(20);

            ms.print();
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        } catch (RuntimeException re) {
            System.out.println(re.getMessage());
        }
    }
}
