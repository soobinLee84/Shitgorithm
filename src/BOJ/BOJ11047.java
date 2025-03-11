package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class BOJ11047 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input1 = br.readLine().split(" ");
        int n = Integer.parseInt(input1[0]);
        int k = Integer.parseInt(input1[1]);

        Integer[] a = new Integer[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(a, Collections.reverseOrder());
        //System.out.println(Arrays.toString(a));

        int result = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] <= k) {
                result += k / a[i];
                k %= a[i];
            }
        }

        System.out.println(result);
    }
}
