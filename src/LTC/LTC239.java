package LTC;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LTC239 {
    public int[] maxSlidingWindow(int[] nums, int k) {

        Deque<Integer> window = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            // 윈도우의 맨앞값이 윈도우를 벗어났는지
            if (!window.isEmpty() && window.peek() < i - k + 1) {
                window.poll();
            }

            // 윈도우의 맨앞값을 최대로 유지
            while (!window.isEmpty() && nums[window.peekLast()] < nums[i]) {
                window.pollLast();
            }

            window.offer(i);

            if (i >= k - 1) {
                result.add(nums[window.peek()]);
            }

        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}
