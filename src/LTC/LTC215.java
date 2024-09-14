package LTC;

import java.util.*;

public class LTC215 {

    public int findKthLargest(int[] nums, int k) {
//        Queue<Integer> h = new PriorityQueue<>(Collections.reverseOrder());

        BinaryHeap h = new BinaryHeap();

        for (int n : nums) {
            h.insert(n);
        }

        for (int i = 0; i < k - 1; i++) {
            h.extract();
        }

        return h.extract();
    }


    public class BinaryHeap {

        public List<Integer> elemens;

        public BinaryHeap() {
            this.elemens = new ArrayList<>();
            elemens.add(null);  // 0번째는 null 추가 후 사용하지 않음
        }

        public void swap(int i, int j) {
            int temp = elemens.get(i);
            elemens.set(i, elemens.get(j));
            elemens.set(j, temp);
        }

        public void insert(int k) {
            elemens.add(k);
            //업힙 연산
            percolateUp();
        }

        private void percolateUp() {
            int last = elemens.size() - 1;  // 마지막에 추가
            int parent = last / 2;

            while (parent > 0) {
                // 부모와 최대값 확인
                if (elemens.get(last) > elemens.get(parent)) {
                    swap(parent, last);
                }

                last = parent;
                parent = last / 2;
            }
        }

        public int extract() {
            int val = elemens.get(1);  // 루트 추출

            elemens.set(1, elemens.get(elemens.size() - 1)); //마지막값 삽입
            elemens.remove(elemens.size() - 1);

            minHeapify(1);

            return val;
        }

        private void minHeapify(int i) {
            int left = i * 2;
            int right = i * 2 + 1;

            int maxIndex = i;

            if (left <elemens.size() && elemens.get(left) > elemens.get(maxIndex)) {
                maxIndex = left;
            }

            if (right <elemens.size() && elemens.get(right) > elemens.get(maxIndex)) {
                maxIndex = right;
            }

            if (maxIndex != i) {
                swap(i, maxIndex);
                minHeapify(maxIndex);
            }
        }
    }
}
