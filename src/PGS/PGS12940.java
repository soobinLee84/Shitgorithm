package PGS;

import java.util.Arrays;

public class PGS12940 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3, 12)));
    }

    public static int[] solution(int n, int m) {
        int[] answer = new int[2];

        answer[0] = gcd(n, m);
        answer[1] = n * m / answer[0];

        return answer;
    }

    public static int gcd(int n, int m) {

        for (int i = (int) Math.min(n, m); i > 0; i--) {
            if (n % i == 0 && m % i == 0)
                return i;
        }

        return 1;
    }
}
