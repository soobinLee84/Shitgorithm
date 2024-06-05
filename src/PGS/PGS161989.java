package PGS;

public class PGS161989 {
    public static void main(String[] args) {
        System.out.println(solution(5, 1, new int[]{1, 2, 4, 5}));
        System.out.println(solution(10, 2, new int[]{1, 3, 6, 8, 10}));
    }

    public static int solution(int n, int m, int[] section) {
        int answer = 1;

        int a = m;
        for (int i = 1; i < section.length; i++) {
            a -= (section[i] - section[i - 1]);

            if (a <= 0) {
                a = m;
                answer++;
            }
        }
        return answer;
    }
}
