package PGS;

import java.util.Arrays;

public class PGS77484 {

    public static void main(String[] args) {
        System.out.println(
            solution(new int[]{44, 1, 0, 0, 31, 25}, new int[]{31, 10, 45, 1, 6, 19}));  //3,5
    }


    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[]{0, 0};  //최고, 최저

        // 최고, 최저 맞은 개수 계산
        for (int i = 0; i < lottos.length; i++) {
            int l = lottos[i];
            if (l == 0) {
                answer[0]++;
            } else if (Arrays.stream(win_nums).anyMatch(n -> l == n)) {
                answer[1]++;
            }
        }
        answer[0] += answer[1];

        //등수 계산
        answer[0] = 7 - answer[0] > 5 ? 6 : 7 - answer[0];
        answer[1] = 7 - answer[1] > 5 ? 6 : 7 - answer[1];

        return answer;
    }

}
