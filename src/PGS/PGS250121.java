package PGS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PGS250121 {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(solution(
                new int[][]{
                        {1, 20300104, 100, 80},
                        {2, 20300804, 847, 37},
                        {3, 20300401, 10, 8}
                },
                "date",
                20300501,
                "remain")));
    }

    public static int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<Data> list = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            list.add(new Data(data[i][0], data[i][1], data[i][2], data[i][3]));
        }

        List<Data> result = list.stream()
                .filter(l -> l.isTarget(ext, val_ext))
                .sorted((a, b) -> {
                    if ("code".equals(sort_by)) {
                        return a.code - b.code;
                    } else if ("date".equals(sort_by)) {
                        return a.date - b.date;
                    } else if ("maximum".equals(sort_by)) {
                        return a.maximum - b.maximum;
                    } else {  //remain
                        return a.remain - b.remain;
                    }
                }).toList();

        int[][] answer = new int[result.size()][4];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i).toArray();
        }

        return answer;
    }

    /**
     * "code", "date", "maximum", "remain"
     */
    public static class Data {
        int code;
        int date;
        int maximum;
        int remain;

        public Data(int code, int date, int maximum, int remain) {
            this.code = code;
            this.date = date;
            this.maximum = maximum;
            this.remain = remain;
        }

        public boolean isTarget(String type, int limit) {
            int value;

            if ("code".equals(type)) {
                value = this.code;
            } else if ("date".equals(type)) {
                value = this.date;
            } else if ("maximum".equals(type)) {
                value = this.maximum;
            } else {  //remain
                value = this.remain;
            }

            return value < limit;
        }

        public int[] toArray() {
            return new int[]{this.code, this.date, this.maximum, this.remain};
        }
    }
}
