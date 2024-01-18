package PGS;

public class PGS12916 {

    public static void main(String[] args) {
        System.out.println(solution("pPoooyY"));
    }

    public static boolean solution(String s) {

        s = s.toLowerCase();
        int p = 0;
        int y = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'p') {
                p++;
            } else if (s.charAt(i) == 'y') {
                y++;
            }
        }

        return p == y ? true : false;
    }

}
