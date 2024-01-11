package PGS;

public class PGS68935 {

    public static void main(String[] args) {
        System.out.println(solution(45));  //7
        System.out.println(solution(125));  //229
    }

    public static int solution(int n) {
        int answer = 0;
        String a = "";

        while (n > 0) {
            a += n % 3;
            n /= 3;
        }

        return Integer.parseInt(String.valueOf(Long.parseLong(a)), 3);
    }

}
