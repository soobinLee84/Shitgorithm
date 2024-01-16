package PGS;

public class PGS12928 {

    public static void main(String[] args) {
        System.out.println(solution(12));
        System.out.println(solution(5));
    }

    public static int solution(int n) {
        int answer = 0;

        for (int i = 1; i < (int) Math.sqrt(n); i++) {
            if (n % i == 0) {
                answer += i;
                answer += (n / i);
            }
        }

        if (Math.sqrt(n) % (int) Math.sqrt(n) == 0) {
            answer += Math.sqrt(n);
        }

        return answer;
    }

}
