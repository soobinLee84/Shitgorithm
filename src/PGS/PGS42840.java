package PGS;

import java.util.Arrays;

public class PGS42840 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 4, 5})));
    }

    public static int[] solution(int[] answers) {
        int[] count = new int[3];
        int[][] math = new int[][]{
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == math[0][i % 5]) {
                count[0]++;
            }

            if (answers[i] == math[1][i % 8]) {
                count[1]++;
            }

            if (answers[i] == math[2][i % 10]) {
                count[2]++;
            }
        }

        int max = Math.max(Math.max(count[0], count[1]), count[2]);
        int c = 0;
        for (int i = 0; i < count.length; i++) {
            if (max == count[i]) {
                c++;
            }
        }

        int[] answer = new int[c];
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            if (max == count[i]) {
                answer[index++] = (i + 1);
            }
        }

        return answer;
    }
}
