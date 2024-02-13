package PGS;

import java.util.Arrays;
import java.util.Comparator;

public class PGS135808 {
    public static void main(String[] args) {
        System.out.println(solution(4, 3, new int[]{4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2}));
    }

    public static int solution(int k, int m, int[] score) {
        int answer = 0;
        Arrays.sort(score);

        for (int i = score.length % m; i < score.length; i += m) {
            answer += (score[i] * m);
        }

        return answer;
    }
}
