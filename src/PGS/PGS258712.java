package PGS;

import java.util.HashMap;
import java.util.Map;

public class PGS258712 {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"muzi", "ryan", "frodo", "neo"},
                new String[]{"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"}));
    }

    public static int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int[] next = new int[friends.length];  //다음달 선물
        int[][] info = new int[friends.length][friends.length];  //준 선물
        int[][] point = new int[friends.length][2];  //주고받은 선물

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < friends.length; i++) {
            map.put(friends[i], i);
        }

        for (int i = 0; i < gifts.length; i++) {
            String[] g = gifts[i].split(" ");
            int a = map.get(g[0]);
            int b = map.get(g[1]);
            info[a][b]++;

            point[a][0]++;
            point[b][1]++;
        }

        for (int i = 0; i < info.length; i++) {
            for (int j = i + 1; j < info[0].length; j++) {

                if (info[i][j] > info[j][i]) {
                    next[i]++;
                } else if (info[i][j] < info[j][i]) {
                    next[j]++;
                } else {
                    if ((point[i][0] - point[i][1]) > (point[j][0] - point[j][1])) {
                        next[i]++;
                    } else if ((point[i][0] - point[i][1]) < (point[j][0] - point[j][1])) {
                        next[j]++;
                    }
                }


            }
        }

        for (int n : next) {
            answer = Math.max(n, answer);
        }

        return answer;
    }
}
