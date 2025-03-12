package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ4796 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int i = 1;
        while (true) {
            String[] input1 = br.readLine().split(" ");
            int l = Integer.parseInt(input1[0]);
            int p = Integer.parseInt(input1[1]);
            int v = Integer.parseInt(input1[2]);

            if (l == 0) {
                break;
            }

            System.out.println("Case " + i + ": " + getResult(l, p, v));
            i++;
        }
    }

    static int getResult(int l, int p, int v) {
        int result = (v / p) * l;
        result += Math.min(v % p, l);

        return result;
    }
}
