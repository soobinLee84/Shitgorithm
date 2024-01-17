package PGS;

import java.util.regex.Pattern;

public class PGS12918 {
    public static void main(String[] args) {
        System.out.println(solution("1234"));
        System.out.println(solution("s123"));
    }

    public static boolean solution(String s) {
        return Pattern.matches("[0-9]{4}|[0-9]{6}", s);
    }
}
