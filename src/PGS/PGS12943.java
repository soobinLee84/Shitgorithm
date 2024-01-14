package PGS;

public class PGS12943 {
    public static void main(String[] args) {
        System.out.println(solution(6));
        System.out.println(solution(626331));
    }

    public static int solution(int num) {
        int i = 0;
        long n = (long) num;

        while (i < 500) {
            if (n == 1) {
                return i;
            }

            if (n % 2 == 0) {
                n /= 2;
            } else {
                n = n * 3 + 1;
            }

            i++;
        }

        return -1;
    }
}
