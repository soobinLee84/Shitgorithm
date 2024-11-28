package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ9093 {

    /**
     * Stack
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder result = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String s = br.readLine();

            for (char c : s.toCharArray()) {
                if (c == ' ') {
                    while (!stack.isEmpty()) {
                        result.append(stack.pop());
                    }

                    result.append(' ');
                } else {
                    stack.push(c);
                }
            }

            if (!stack.isEmpty()) {
                while (!stack.isEmpty()) {
                    result.append(stack.pop());
                }
            }

            result.append("\n");
        }

        System.out.println(result.toString());
    }

    /**
     * StringBuilder
     *
     * @param args
     * @throws IOException
     */
    public static void main2(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder result = new StringBuilder();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String[] words = br.readLine().split(" ");

            for (String word : words) {
                result.append(sb.append(word).reverse()).append(" ");
                sb.setLength(0);
            }
            result.append("\n");
        }

        System.out.println(result.toString());
    }

}
