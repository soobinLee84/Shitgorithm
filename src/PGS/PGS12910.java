package PGS;

import java.util.Arrays;

public class PGS12910 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{5, 6, 7, 10}, 5));
    }

    public static int[] solution(int[] arr, int divisor) {
        int size = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % divisor == 0) {
                size++;
            } else {
                arr[i] = 0;
            }
        }

        if (size == 0) {
            return new int[]{-1};
        }

        Arrays.sort(arr);
        int[] answer = new int[size];
        for (int i = answer.length - 1; i > -1; i--) {
            answer[i] = arr[i + arr.length - size];
        }

        return answer;
    }
}
