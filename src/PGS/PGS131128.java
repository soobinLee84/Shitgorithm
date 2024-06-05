package PGS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PGS131128 {
    public static void main(String[] args) {
//        System.out.println(solution("100", "2345"));
//        System.out.println(solution("100", "203045"));
//        System.out.println(solution("5525", "1255"));
        System.out.println(solution("12321", "42531"));
    }

    public static String solution(String X, String Y) {
        List<String> list = new ArrayList<>();

        String[] sx = X.split("");
        String[] sy = Y.split("");
        Arrays.sort(sx);
        Arrays.sort(sy);

        int yIndex = 0;
        boolean zero = true;
        for (int i = 0; i < sx.length; i++) {
            for (int j = yIndex; j < sy.length; j++) {
                int sxi = Integer.parseInt(sx[i]);
                int syi = Integer.parseInt(sy[yIndex]);

                if (sxi < syi)
                    break;

                if (sxi == syi) {
                    list.add(sx[i]);
                    yIndex++;

                    if (!"0".equals(sx[i]))
                        zero = false;

                    break;
                }
                yIndex++;
            }
        }

        if (list.isEmpty())
            return "-1";

        if (zero)
            return "0";

        list.sort(Collections.reverseOrder());
        return String.join("", list);
    }
}
