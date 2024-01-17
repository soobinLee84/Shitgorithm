package PGS;

public class PGS12921 {
    public static void main(String[] args) {
        System.out.println(solution(10));
        System.out.println(solution(5));
    }

    public static int solution(int n) {
        boolean[] array = new boolean[n + 1];

        for (int i = 2; i <= n; i++) {
            if (array[i])
                continue;

            int j = 2;
            while (i * j <= n) {
                array[i * j] = true;
                j++;
            }
        }

        int answer = 0;
        for (int i = 2; i < array.length; i++) {
            if (!array[i])
                answer++;
        }

        return answer;
    }
}
