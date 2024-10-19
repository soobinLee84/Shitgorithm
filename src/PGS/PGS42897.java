package PGS;

public class PGS42897 {
    public int solution(int[] money) {
        if (money.length == 1) return money[0];

        int[][] dp = new int[2][money.length];

        // 첫번째집 훔치고 마지막 전집 훔침
        dp[0][0] = money[0];
        dp[0][1] = Math.max(money[0], money[1]);

        // 첫번째집 안훔치고 마지막집 훔침
        dp[1][0] = 0;
        dp[1][1] = money[1];

        for (int i = 2; i < money.length; i++) {
            // i번째 집에서 최대 수익
            // 전집에서 훔쳤을 경우 수익 | 이번집 훔치고 전전집에서 훔쳤을 경우 수익
            dp[0][i] = Math.max(dp[0][i - 1], dp[0][i - 2] + money[i]);
            dp[1][i] = Math.max(dp[1][i - 1], dp[1][i - 2] + money[i]);
        }

        // 첫번째집을 훔치면 마지막 전집까지 훔칠수 있음
        // 첫번째집 훔치지 않으면 마지막 집까지 훔칠 수 있음
        return Math.max(dp[0][money.length - 2], dp[1][money.length - 1]);
    }
}
