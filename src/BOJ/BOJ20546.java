package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ20546 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 현금
        int junCash = Integer.parseInt(br.readLine());
        int sungCash = junCash;

        // 주식
        int junStock = 0;
        int sungStock = 0;

        String[] spl = br.readLine().split(" ");
        int[] stock = new int[spl.length + 1];
        for (int i = 0; i < spl.length; i++) {
            stock[i + 1] = Integer.parseInt(spl[i]);
        }
        stock[0] = stock[1];

        for (int i = 0; i < stock.length; i++) {

            // jun

            // sung
        }


    }
}
