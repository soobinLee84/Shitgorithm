package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1463 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());

        System.out.println(solution(x));
    }

    private static int solution(int x) {
        int[] dp = new int[x + 1];
        dp[1] = 0;  // 1일 때는 0번

        for (int i = 2; i <= x; i++) {

            // ③ -1
            dp[i] = dp[i - 1] + 1;

            // ② / 2
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }

            // ① / 3
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }

        return dp[x];
    }
}
