package LTC;

import java.util.ArrayDeque;
import java.util.Deque;

public class LTC316 {
    public String removeDuplicateLetters(String s) {

        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        boolean[] contains = new boolean[26];
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            count[c - 'a']--;

            if (contains[c - 'a']) {
                continue;
            }

            // 이번에 추가할 문자가 마지막 문자보다 사전상 앞이어서 나중에 한번더 등장하는 문자면 제거
            while (!stack.isEmpty() && stack.peek() > c && count[stack.peek() - 'a'] > 0) {
                contains[stack.pop() - 'a'] = false;
            }

            stack.push(c);
            contains[c - 'a'] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }

        return sb.toString();
    }
}
