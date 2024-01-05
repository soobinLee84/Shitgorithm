package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BOJ1655 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new LinkedList<>();

        int input;
        for (int i = 0; i < n; i++) {
            input = Integer.parseInt(br.readLine());
            list.add(input);
            Collections.sort(list);
            System.out.println(getCenter(list));

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

