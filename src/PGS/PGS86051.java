package PGS;

public class PGS86051 {

    public static void main(String[] args) {

        System.out.println(solution(new int[]{1, 2, 3, 4, 6, 7, 8, 0}));  //14
        System.out.println(solution(new int[]{5, 8, 4, 0, 6, 7, 9}));  //6

    }

    public static int solution(int[] numbers) {
        int answer = -1;

        answer = 9 * (9 + 1) / 2;

        for (int i = 0; i < numbers.length; i++) {
            answer -= numbers[i];
        }

        return answer;
    }
}
