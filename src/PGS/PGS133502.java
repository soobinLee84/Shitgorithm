package PGS;

import java.util.Stack;

public class PGS133502 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 1, 1, 2, 3, 1, 2, 3, 1}));
//        System.out.println(solution(new int[]{1, 3, 2, 1, 2, 1, 3, 1, 2}));
    }

    public static int solution(int[] ingredient) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();

        int[] a = new int[4];
        for (int i : ingredient) {
            stack.push(i);

            if (stack.size() > 3) {
                a[3] = stack.pop();
                a[2] = stack.pop();
                a[1] = stack.pop();
                a[0] = stack.pop();

                if (a[0] == 1 && a[1] == 2 && a[2] == 3 && a[3] == 1) {
                    answer++;
                } else {
                    stack.push(a[0]);
                    stack.push(a[1]);
                    stack.push(a[2]);
                    stack.push(a[3]);
                }
            }
        }

        return answer;
    }
}
