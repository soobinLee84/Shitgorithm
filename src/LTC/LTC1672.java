package LTC;

/**
 * 1672. Richest Customer Wealth
 */
public class LTC1672 {

    public int maximumWealth(int[][] accounts) {
        int max = 0;

        for (int i = 0; i < accounts.length; i++) {
            int num = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                num += accounts[i][j];
            }

            max = Math.max(max, num);
        }

        return max;
    }
}
