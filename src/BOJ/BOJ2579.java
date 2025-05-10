package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2579 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] point = new int[n + 1];
        for (int i = 1; i < point.length; i++) {
            point[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(solution(point));
    }

    private static int solution(int[] point) {
        int[] dp = new int[point.length];
        dp[0] = 0;
        dp[1] = point[1];

        if (point.length > 2) {
            dp[2] = dp[1] + point[2];
        }

        for (int i = 3; i < point.length; i++) {
            dp[i] = Math.max(dp[i - 3] + point[i - 1] + point[i], dp[i - 2] + point[i]);
        }

        return dp[point.length - 1];
    }
}
