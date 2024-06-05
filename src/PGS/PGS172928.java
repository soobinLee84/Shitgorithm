package PGS;

import java.util.Arrays;

public class PGS172928 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                solution(new String[]{"SOO", "OOO", "OOO"}, new String[]{"E 2", "S 2", "W 1"})));
    }

    public static int[] solution(String[] park, String[] routes) {
        int[] answer = new int[]{-1, -1};

        // S 찾기
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[0].length(); j++) {
                if ('S' == park[i].charAt(j)) {
                    answer[0] = i;
                    answer[1] = j;
                    break;
                }
            }

            if (answer[0] != -1) {
                break;
            }
        }

        for (int i = 0; i < routes.length; i++) {
            int[] move = new int[]{answer[0], answer[1]};
            String[] r = routes[i].split(" ");
            int n = Integer.parseInt(r[1]);

            if ("E".equals(r[0])) {
                move[1] += n;
                if (move[1] >= park[0].length()) continue;

            } else if ("W".equals(r[0])) {
                move[1] -= n;
                if (move[1] < 0) continue;

            } else if ("S".equals(r[0])) {
                move[0] += n;
                if (move[0] >= park.length) continue;

            } else {  // N
                move[0] -= n;
                if (move[0] < 0) continue;
            }

            boolean isSuccess = true;
            for (int i1 = Math.min(answer[0], move[0]); i1 <= Math.max(answer[0], move[0]); i1++) {
                if ('X' == park[i1].charAt(answer[1])) {
                    isSuccess = false;
                    break;
                }
            }
            if (!isSuccess) continue;

            isSuccess = true;
            for (int i1 = Math.min(answer[1], move[1]); i1 <= Math.max(answer[1], move[1]); i1++) {
                if ('X' == park[answer[0]].charAt(i1)) {
                    isSuccess = false;
                    break;
                }
            }
            if (!isSuccess) continue;

            answer = move;

        }

        return answer;
    }
}
