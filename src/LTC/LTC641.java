package LTC;

import java.util.Arrays;

/**
 * 641. Design Circular Deque
 */

public class LTC641 {

    static class MyCircularDeque {
        private int[] deque;
        private int size;
        private int front;
        private int rear;
        private int capacity;

        public MyCircularDeque(int k) {
            this.deque = new int[k];
            this.capacity = k;
        }

        public boolean insertFront(int value) {
            if (isFull()) return false;

            // 증가하고 저장
            front = (front - 1 + capacity) % capacity;
            deque[front] = value;
            size++;
            return true;
        }

        public boolean insertLast(int value) {
            if (isFull()) return false;

            // 저장하고 증가
            deque[rear] = value;
            rear = (rear + 1) % capacity;
            size++;
            return true;
        }

        public boolean deleteFront() {
            if (isEmpty()) return false;

            int value = deque[front];
            front = (front + 1) % deque.length;
            size--;
            return true;
        }

        public boolean deleteLast() {
            if (isEmpty()) return false;

            rear = (rear - 1 + capacity) % capacity;
            int value = deque[rear];
            size--;
            return true;
        }

        public int getFront() {
            if (isEmpty()) return -1;

            // 증가하고 저장하기 때문에 바로 조회
            return deque[front];
        }

        public int getRear() {
            if (isEmpty()) return -1;

            // 저장하고 증가하기 때문에 이동 후 조회
            return deque[(rear - 1 + capacity) % capacity];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == capacity;
        }

        @Override
        public String toString() {
            return Arrays.toString(deque);
        }
    }

    public static void main(String[] args) {
        /*
            ["MyCircularDeque","insertLast","insertLast","insertFront","insertFront","getRear","isFull","deleteLast","insertFront","getFront"]
            [[3],[1],[2],[3],[4],[],[],[],[4],[]]

            [null,true,true,true,false,2,true,true,true,4]
         */

        MyCircularDeque deque = new MyCircularDeque(3);
        System.out.println(deque.insertLast(1));
        System.out.println(deque.insertLast(2));
        System.out.println(deque.insertFront(3));
        System.out.println(deque);
        System.out.println(deque.insertFront(4));
        System.out.println(deque.getRear());
        System.out.println(deque.getRear());
        System.out.println(deque.isFull());
        System.out.println(deque.deleteLast());
        System.out.println(deque);
        System.out.println(deque.insertFront(4));
        System.out.println(deque.getFront());
        System.out.println(deque);

    }
}
