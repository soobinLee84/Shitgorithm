package PGS;

public class PGS12926 {

    public static void main(String[] args) {
        System.out.println(solution("AB", 1));
        System.out.println(solution("z", 1));
        System.out.println(solution("a B z", 4));
    }

    public static String solution(String s, int n) {
        String answer = "";

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                answer += ' ';
            } else if (Character.isUpperCase(s.charAt(i))) {
                answer += (char) ((s.charAt(i) + n - 'A') % 26 + 'A');
            } else {
                answer += (char) ((s.charAt(i) + n - 'a') % 26 + 'a');
            }
        }

        return answer;
    }

}
