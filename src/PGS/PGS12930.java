package PGS;

public class PGS12930 {

    public static void main(String[] args) {
        System.out.println(solution("try hello world"));
    }

    public static String solution(String s) {
        String[] ss = s.toLowerCase().split("");

        int index = 1;
        for (int i = 0; i < ss.length; i++) {
            index++;
            if (" ".equals(ss[i])) {
                index = 1;
            } else if (index % 2 == 0) {
                ss[i] = ss[i].toUpperCase();
            }
        }

        return String.join("", ss);
    }
}
