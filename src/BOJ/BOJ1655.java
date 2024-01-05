package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class BOJ1655 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> list = new LinkedList<>();
        list.add(Integer.parseInt(br.readLine()));
        System.out.println(getCenter(list));

        int input;
        for (int i = 0; i < n - 1; i++) {
            input = Integer.parseInt(br.readLine());
            list.add(aaa(list, input), input);
            System.out.println(getCenter(list));
        }

    }

    private static int aaa(List<Integer> list, int n) {
        return bbb(list, n, 0, list.size() - 1);
    }

    private static int bbb(List<Integer> list, int n, int start, int end) {
        if (start == end) {
            return list.get(start) < n ? start + 1 : start;
        }

        int size = end - start + 1;
        int center = start + (size / 2);

        if (list.get(center) <= n) {
            return bbb(list, n, center + 1, end);
        } else {
            return bbb(list, n, start, center - 1);
        }
    }

    public static int getCenter(List<Integer> list) {

        int size = list.size();
        int centerIndex = size / 2;
        int center = list.get(centerIndex);
        int center2;

        if (size % 2 == 0) {
            center2 = list.get(centerIndex - 1);
            center = center > center2 ? center2 : center;
        }

        return center;
    }
}

