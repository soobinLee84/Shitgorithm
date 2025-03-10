package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2512 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int m = Integer.parseInt(br.readLine());

        int[] money = new int[n];
        int total = 0;
        int max = 0;
        for (int i = 0; i < money.length; i++) {
            money[i] = Integer.parseInt(input[i]);
            total += money[i];
            max = Math.max(max, money[i]);
        }

        if (total <= m) {
            System.out.println(max);
            return;
        }

        int left = 0, right = max;
        int result = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long sum = getSum(money, mid);

            if (sum <= m) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);
    }

    static long getSum(int[] money, int l) {
        long sum = 0;

        for (int m : money) {
            sum += Math.min(m, l);
        }

        return sum;
    }

}
