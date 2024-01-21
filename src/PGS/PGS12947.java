package PGS;

public class PGS12947 {
    public static void main(String[] args) {
        System.out.println(solution(10));
        System.out.println(solution(11));
        System.out.println(solution(12));
        System.out.println(solution(13));
    }

    public static boolean solution(int x) {

        String s = Integer.toString(x);
        double y = 0;
        for (int i = 0; i < s.length(); i++) {
            y += s.charAt(i) - '0';
        }

        return x % y == 0;
    }
}
