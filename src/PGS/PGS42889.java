package PGS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PGS42889 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3})));
    }

    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N + 1];

        int total = 0;
        for (int i = 0; i < stages.length; i++) {
            total += 1;

            if (stages[i] == N + 1)
                continue;

            answer[stages[i]] += 1;
        }

        List<Stage> list = new ArrayList<>();
        for (int i = 1; i < answer.length; i++) {
            list.add(new Stage(i, (float) answer[i] / total));
            total -= answer[i];
        }

        Collections.sort(list);

        int[] result = new int[N];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i).getNum();
        }

        return result;
    }

    public static class Stage implements Comparable {
        private int num;
        private float fail;

        public Stage(int num, float fail) {
            this.num = num;
            this.fail = fail;
        }

        public int getNum() {
            return num;
        }

        @Override
        public int compareTo(Object o) {
            Stage s = (Stage) o;

            if (this.fail > s.fail)
                return -1;
            else if (this.fail < s.fail)
                return 1;
            return this.num - s.num;
        }
    }
}
