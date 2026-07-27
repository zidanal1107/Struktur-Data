package Queue;

class MyQueue {
    int front;
    int rear;
    int[] array;
    int nItem;
    int maxSize;

    public MyQueue(int maxSize) {
        this.maxSize = maxSize;
        rear = -1;
        front = 0;
        nItem = 0;
        array = new int[maxSize];
    }

    public boolean isFull() {
        return nItem == maxSize;
    }

    public boolean isEmpty() {
        return nItem == 0;
    }

    public void enqueue(int data) {
        if (isFull())
            throw new RuntimeException("Array is full");
        array[++rear] = data;
        nItem++;
    }

    public int dequeue() {
        if (isEmpty())
            throw new RuntimeException("Array is empty");
        nItem--;
        return array[front++];
    }

    public void read() {
        if (isEmpty())
            throw new RuntimeException("Array is empty");
        for (int i = front; i <= rear; i++)
            System.out.print(array[i] + " ");
    }

    public void update(int index, int data) {
        if (isEmpty())
            throw new RuntimeException("Array is empty");
        else if (index > rear || index < front)
            throw new IndexOutOfBoundsException("Invalid index");
        array[index] = data;
    }

    public int peek() {
        if (isEmpty())
            throw new RuntimeException("Array is empty");
        return array[front];
    }

    public void clear() {
        front = 0;
        rear = -1;
        nItem = 0;
    }

    public boolean contains(int data) {
        if (isEmpty())
            throw new RuntimeException("Array is empty");
        for (int i = front; i <= rear; i++) {
            if (array[i] == data)
                return true;
        }
        return false;
    }

    public int search(int data) {
        if (isEmpty())
            throw new RuntimeException("Array is empty");
        for (int i = front; i <= rear; i++) {
            if (array[i] == data)
                return i;
        }
        return -1;
    }
}

class MyQueueCircular {
    int front;
    int rear;
    int[] array;
    int nItem;
    int maxSize;

    public MyQueueCircular(int maxSize) {
        this.maxSize = maxSize;
        rear = -1;
        front = 0;
        nItem = 0;
        array = new int[maxSize];
    }

    public boolean isFull() {
        return nItem == maxSize;
    }

    public boolean isEmpty() {
        return nItem == 0;
    }

    public void enqueue(int data) {
        if (isFull())
            throw new RuntimeException("Array is full");
        rear = (rear + 1) % maxSize;
        array[rear] = data;
        nItem++;
    }

    public int dequeue() {
        if (isEmpty())
            throw new RuntimeException("Array is empty");
        int temp = array[front];
        front = (front + 1) % maxSize;
        nItem--;
        return temp;
    }

    public void read() {
        if (isEmpty())
            throw new RuntimeException("Array is empty");
        int c = front;
        for (int i = 0; i < nItem; i++) {
            System.out.print(array[c] + " ");
            c = (c + 1) % maxSize;
        }
    }

    public int peek() {
        if (isEmpty())
            throw new RuntimeException("Array is empty");
        front = front % maxSize;
        return array[front];
    }

    public boolean contains(int data) {
        if (isEmpty())
            throw new RuntimeException("Array is empty");
        int c = front;
        for (int i = 0; i < nItem; i++) {
            if (array[c] == data) {
                return true;
            }
            c = (c + 1) % maxSize;
        }
        return false;
    }

    public int search(int data) {
        if (isEmpty())
            return -1;
        int c = front;
        for (int i = 0; i < nItem; i++) {
            if (array[c] == data)
                return i;
            c = (c + 1) % maxSize;
        }
        return -1;
    }
}

public class QueueMain {
    public static void main(String[] args) {
        MyQueueCircular mq = new MyQueueCircular(5);

        try {
            mq.enqueue(10);
            mq.enqueue(20);
            mq.enqueue(30);
            mq.enqueue(40);
            mq.enqueue(50);

            mq.dequeue();
            mq.dequeue();
            mq.dequeue();

            mq.enqueue(60);
            mq.read();
            System.out.println(mq.nItem);
            System.out.println(mq.peek());
            System.out.println(mq.contains(30));
            System.out.println(mq.search(60));
        } catch (RuntimeException re) {
            System.out.println(re.getMessage());
        }
    }
}
