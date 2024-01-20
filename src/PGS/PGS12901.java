package PGS;

public class PGS12901 {
    public static void main(String[] args) {
        System.out.println(solution(5, 27));
    }

    public static String solution(int a, int b) {
        int[] m = new int[]{0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] w = new String[]{"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};

        int n = b;
        for (int i = 1; i < a; i++) {
            n += m[i];
        }

        return w[n % 7];
    }
}
