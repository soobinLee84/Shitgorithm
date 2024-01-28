package PGS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PGS138477 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3, new int[]{10, 100, 20, 150, 1, 100, 200})));
    }

    public static int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];

        List<Integer> list = new ArrayList<>();
        int min = score[0];
        for (int i = 0; i < k; i++) {
            if (score.length <= i) break;

            list.add(score[i]);
            min = Math.min(min, score[i]);
            answer[i] = min;
        }

        list.sort(Collections.reverseOrder());

        min = list.get(list.size() - 1);
        for (int i = k; i < score.length; i++) {
            if (min < score[i]) {
                list.add(score[i]);
                list.sort(Collections.reverseOrder());
                list.remove(list.size() - 1);
            }

            answer[i] = list.get(list.size() - 1);
        }

        return answer;
    }
}
