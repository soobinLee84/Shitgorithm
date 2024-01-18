package PGS;

import java.util.Arrays;
import java.util.Collections;

public class PGS12917 {

    public static void main(String[] args) {
        System.out.println(solution("Zbcdefg"));
    }

    public static String solution(String s) {
        String[] ss = s.split("");
        Arrays.sort(ss, Collections.reverseOrder());
        return String.join("", ss);
    }
}
