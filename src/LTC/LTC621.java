package LTC;

import java.util.*;

public class LTC621 {

    public int leastInterval(char[] tasks, int n) {

        // 빈도
        int[] freqs = new int[26];
        for (char c : tasks) {
            freqs[c - 'A']++;
        }

        // 빈도 역순 정렬
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int f : freqs) {
            if (f > 0) {
                pq.add(f);
            }
        }

        int result = 0;

        while (true) {
            int interval = 0;
            List<Integer> list = new ArrayList<>();

            while (!pq.isEmpty()) {
                int freq = pq.poll();  // 최대값

                if (interval < n + 1) {
                    interval++;
                    result++;

                    if (freq > 1) {
                        list.add(freq - 1);
                    }

                } else {
                    list.add(freq);
                }
            }

            if (list.isEmpty()) {
                break;
            }

            pq.addAll(list);
            result += n + 1 - interval;
        }

        return result;
    }

}
