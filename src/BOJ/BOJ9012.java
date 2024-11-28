package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ9012 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {
            result.append(isValid(br.readLine())).append("\n");
        }

        System.out.println(result.toString());
    }

    public static String isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if ('(' == c) {
                stack.push(')');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return "NO";
            }
        }

        return stack.isEmpty() ? "YES" : "NO";
    }
}
