package PGS;

public class PGS147355 {

    public static void main(String[] args) {
        System.out.println(solution("3141592", "271"));
    }

    public static int solution(String t, String p) {
        int answer = 0;
        long intP = Long.parseLong(p);

        for (int i = 0; i <= t.length() - p.length(); i++) {
            if (intP >= Long.parseLong(t.substring(i, i + p.length()))) {
                answer++;
            }
        }

        return answer;
    }

}
