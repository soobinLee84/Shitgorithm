package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2231 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 1; i < n; i++) {
            if (n == getSum(i)) {
                System.out.println(i);
                return;
            }
        }

        System.out.println("0");
    }

    static int getSum(int n) {
        int sum = n;

        while (n > 0) {
            sum += (n % 10);
            n /= 10;
        }

        return sum;
    }
}
