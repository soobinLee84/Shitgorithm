package PGS;

import java.util.ArrayList;
import java.util.List;

public class PGS12906 {

    public static void main(String[] args) {

        System.out.println(solution(new int[]{1, 1, 3, 3, 0, 1, 1}));
    }

    public static int[] solution(int[] arr) {

        int size = 1;
        int n = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (n != arr[i]) {
                n = arr[i];
                size++;
            }
        }

        int[] answer = new int[size];
        answer[0] = arr[0];
        n = arr[0];
        size = 1;
        for (int i = 1; i < arr.length; i++) {
            if (n != arr[i]) {
                n = arr[i];
                answer[size++] = arr[i];
            }
        }

        return answer;
    }

    public static int[] solution1(int[] arr) {

        List<Integer> list = new ArrayList<>();
        list.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            if (list.get(list.size() - 1) != arr[i]) {
                list.add(arr[i]);
            }
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

}
