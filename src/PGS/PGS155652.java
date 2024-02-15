package PGS;

import java.util.ArrayList;
import java.util.List;

public class PGS155652 {
    public static void main(String[] args) {
        System.out.println(solution("aukks", "wbqd", 5));
    }

    public static String solution(String s, String skip, int index) {
        List<String> alpa = new ArrayList<>();

        for (int i = 0; i <= 'z' - 'a'; i++) {
            alpa.add(String.valueOf((char) ('a' + i)));
        }

        String[] skipS = skip.split("");
        for (int i = 0; i < skipS.length; i++) {
            alpa.remove(skipS[i]);
        }

        System.out.println(alpa);

        String[] ss = s.split("");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ss.length; i++) {
            sb.append(alpa.get((alpa.indexOf(ss[i]) + index) % alpa.size()));
        }

        return sb.toString();
    }
}
