package PGS;

public class PGS12919 {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"Jane", "Kim"}));
    }

    public static String solution(String[] seoul) {

        int answer = 0;
        for (int i = 0; i < seoul.length; i++) {
            if ("Kim".equals(seoul[i])) {
                answer = i;
                break;
            }
        }

        return "김서방은 " + answer + "에 있다";
    }
}
