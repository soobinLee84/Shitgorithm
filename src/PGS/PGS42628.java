package PGS;

import java.util.*;

public class PGS42628 {
    public int[] solution(String[] operations) {
        Queue<Integer> minHeap = new PriorityQueue<>();
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (String o : operations) {
            String[] split = o.split(" ");

            if ("I".equals(split[0])) {
                int i = Integer.parseInt(split[1]);
                minHeap.add(i);
                maxHeap.add(i);

            } else if ("D".equals(split[0])) {
                if ("1".equals(split[1])) {
                    minHeap.remove(maxHeap.poll());

                } else if ("-1".equals(split[1])) {
                    maxHeap.remove(minHeap.poll());
                }
            }
        }


        int min = minHeap.peek() == null ? 0 : minHeap.poll();
        int max = maxHeap.peek() == null ? 0 : maxHeap.poll();

        return new int[]{max, min};
    }
}