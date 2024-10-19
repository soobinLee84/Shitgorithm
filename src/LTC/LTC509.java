package LTC;

public class LTC509 {
    public int fib(int n) {
        if (n <= 1)
            return n;

        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public int fib2(int n) {
        if (n <= 1) {
            return n;
        }

        int x = 0, y = 1;
        for (int i = 2; i <= n; i++) {
            int z = x + y;
            x = y;
            y = z;
        }

        return y;
    }
}
