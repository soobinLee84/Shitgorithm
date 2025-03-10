package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2805 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");
        int[] wood = new int[n];
        int max = 0;

        for (int i = 0; i < n; i++) {
            wood[i] = Integer.parseInt(input[i]);
            max = Math.max(max, wood[i]);
        }

        //System.out.println(Arrays.toString(wood));

        int min = 0, result = 0;
        while (min <= max) {
            int mid = min + (max - min) / 2;
            long sum = getSum(wood, mid);

            if (sum >= m) {
                result = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        System.out.println(result);

    }

    static long getSum(int[] wood, int h) {
        long sum = 0;

        for (int w : wood) {
            if (w > h) {
                sum += w - h;
            }
        }

        return sum;
    }
}
