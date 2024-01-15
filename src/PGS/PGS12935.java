package PGS;

public class PGS12935 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{4, 3, 2, 1}));
        System.out.println(solution(new int[]{10}));
    }

    public static int[] solution(int[] arr) {

        if (arr.length == 1) {
            return new int[]{-1};
        }

        int index = 0;
        int value = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < value) {
                index = i;
                value = arr[i];
            }
        }

        int[] answer = new int[arr.length - 1];

        for (int i = 0; i < index; i++) {
            answer[i] = arr[i];
        }

        for (int i = index; i < answer.length; i++) {
            answer[i] = arr[i + 1];
        }

        return answer;
    }

}
