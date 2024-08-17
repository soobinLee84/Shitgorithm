package LTC;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LTC347 {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }


        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int key : map.keySet()) {
            q.add(new int[]{key, map.get(key)});
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = q.poll()[0];
        }

        return res;
    }
}
