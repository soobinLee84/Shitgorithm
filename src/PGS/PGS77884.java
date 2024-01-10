package PGS;

public class PGS77884 {

    public static void main(String[] args) {
        System.out.println(solution(13, 17));
        System.out.println(solution(24, 27));
    }

    public static int solution(int left, int right) {
        int answer = 0;

        for (int i = left; i < right + 1; i++) {
            double a = Math.sqrt(i);
            answer += (a == (int) a ? -i : i);
        }

        return answer;
    }

}
