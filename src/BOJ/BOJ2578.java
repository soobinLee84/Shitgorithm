package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BOJ2578 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, int[]> map = new HashMap<>();

        // 철수꺼 받기
        for (int i = 0; i < 5; i++) {
            String[] spl = br.readLine().split(" ");

            for (int j = 0; j < spl.length; j++) {
                // 받으면서 map에 초기화
                map.put(spl[j], new int[]{i, j});
            }
        }

        // 관리자꺼 받기 인덱스 증가
        int count = 0;
        int result = 0;
        int[] check = new int[12];
        int bingo = 0;
        for (int i = 0; i < 5; i++) {

            String[] spl = br.readLine().split(" ");

            for (int j = 0; j < spl.length; j++) {
                count++;
                // map에서 찾아와서 빙고 정보 넣기
                int[] v = map.get(spl[j]);

                check[v[0]]++;
                if (check[v[0]] == 5) {
                    bingo++;
                }
                check[v[1] + 5]++;
                if (check[v[1] + 5] == 5) {
                    bingo++;
                }
                if (v[0] == v[1]) {
                    check[10]++;
                    if (check[10] == 5) {
                        bingo++;
                    }
                }
                if (v[0] + v[1] == 4) {
                    check[11]++;
                    if (check[11] == 5) {
                        bingo++;
                    }
                }

                if (result == 0 && bingo >= 3) {
                    result = count;
                }
            }
        }

        System.out.println(result);
    }
}
