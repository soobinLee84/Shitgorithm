package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ1655 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        list.add(Integer.parseInt(br.readLine()));
        builder.append(getCenterIndex(list)).append("\n");

        int input;
        for (int i = 0; i < n - 1; i++) {
            input = Integer.parseInt(br.readLine());
            list.add(sortedIndex(list, input), input);
            builder.append(getCenterIndex(list)).append("\n");
        }

        System.out.println(builder);

    }

    /**
     * 정렬된 상태로 추가될 인덱스
     * @param list
     * @param n
     * @return
     */
    public static int sortedIndex(List<Integer> list, int n) {
        return rec_sortedIndex(list, n, 0, list.size() - 1);
    }

    private static int rec_sortedIndex(List<Integer> list, int n, int start, int end) {
        if (start > end) { // 짝수개 일때 최대값 처리용
            return start;
        }

        if (start == end) {
            return list.get(start) < n ? start + 1 : start;
        }

        int size = end - start + 1;
        int center = start + (size / 2);

        if (list.get(center) <= n) {
            return rec_sortedIndex(list, n, center + 1, end);
        } else {
            return rec_sortedIndex(list, n, start, center - 1);
        }
    }

    /**
     * list의 가운데 인덱스
     * @param list
     * @return
     */
    public static int getCenterIndex(List<Integer> list) {

        int size = list.size();
        int centerIndex = size / 2;

        return size % 2 == 0 ? list.get(centerIndex - 1) : list.get(centerIndex);
    }
}

