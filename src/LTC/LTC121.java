package LTC;

public class LTC121 {
    public int maxProfit(int[] prices) {
        int[] a = new int[prices.length];

        int max = prices[prices.length - 1];
        a[prices.length - 1] = 0;

        for (int i = prices.length - 2; i >= 0; i--) {
            a[i] = max;
            max = Math.max(max, prices[i]);
        }

        max = 0;
        for (int i = 0; i < a.length - 1; i++) {
            max = Math.max(max, a[i] - prices[i]);
        }

        return max;
    }
}
