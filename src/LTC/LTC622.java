package LTC;

public class LTC622 {
    int[] arr;
    int max;
    int size = 0;
    int front = 0;
    int rear = -1;

    public LTC622(int k) {
        arr = new int[k];
        max = k;
    }

    public boolean enQueue(int value) {
        if (isFull())
            return false;

        rear = (rear + 1) % max;
        arr[rear] = value;
        size++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty())
            return false;

        int val = arr[front];
        front = (front + 1) % max;
        size--;
        return true;
    }

    public int Front() {
        if (isEmpty())
            return -1;
        return arr[front];
    }

    public int Rear() {
        if (isEmpty())
            return -1;
        return arr[rear];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == max;
    }
}
