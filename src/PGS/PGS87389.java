package PGS;

public class PGS87389 {

    public static void main(String[] args) {
        System.out.println(solution(10));  //3
        System.out.println(solution(12));  //11
    }

    public static int solution(int n) {
        int answer = 0;

        for (int i = 2; i < n; i++) {
            if (n % i == 1) {
                answer = i;
                break;
            }
        }

        return answer;
    }

}
