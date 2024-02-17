package PGS;

import java.util.Arrays;

public class PGS161990 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"...#"})));
    }

    public static int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        answer[0] = Integer.MAX_VALUE;
        answer[1] = Integer.MAX_VALUE;


        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[0].length(); j++) {
                if ('.' == wallpaper[i].charAt(j))
                    continue;

                answer[0] = Math.min(answer[0], i);
                answer[1] = Math.min(answer[1], j);
                answer[2] = Math.max(answer[2], i);
                answer[3] = Math.max(answer[3], j);

            }
        }

        answer[2]++;
        answer[3]++;
        return answer;
    }
}
