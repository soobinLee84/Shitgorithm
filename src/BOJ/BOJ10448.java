package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ10448 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        List<Integer> tri = new ArrayList<>();
        tri.add(1);

        // 1 0 1
        kfor:
        for (int i = 0; i < t; i++) {
            int k = Integer.parseInt(br.readLine());

            while (tri.get(tri.size() - 1) < k) {
                tri.add(getTri(tri.size() + 1));
            }

            for (int a = 0; a < tri.size(); a++) {
                for (int b = a; b < tri.size(); b++) {
                    for (int c = b; c < tri.size(); c++) {
                        if (k == tri.get(a) + tri.get(b) + tri.get(c)) {
                            System.out.println("1");
                            continue kfor;
                        }
                    }
                }
            }

            System.out.println("0");

        }
    }

    static int getTri(int n) {
        return n * (n + 1) / 2;
    }

}
