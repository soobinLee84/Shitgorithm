package LTC;

import java.util.ArrayDeque;
import java.util.Deque;

public class LTC739 {

    public int[] dailyTemperatures(int[] t) {

        int[] result = new int[t.length];

        Deque<Integer> stack = new ArrayDeque<>();  // index

        for (int i = 0; i < t.length; i++) {
            while (!stack.isEmpty() && t[stack.peek()] < t[i]) {
                int index = stack.pop();
                result[index] = i - index;
            }

            stack.push(i);
        }

        return result;
    }
}
