package PGS;

import java.util.Arrays;

public class PGS12915 {

    public static void main(String[] args) {
        System.out.println(solution(new String[]{"sun", "bed", "car"}, 1));
    }

    public static String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (a, b) -> {
            if (a.charAt(n) == b.charAt(n)) {
                return a.compareTo(b);
            }

            return a.charAt(n) - b.charAt(n);
        });

        return strings;
    }

}
