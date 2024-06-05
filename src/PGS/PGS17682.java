package PGS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PGS17682 {
    public static void main(String[] args) {
        System.out.println(solution("1S2D*3T*"));
//        System.out.println(solution("1D2S#10S"));
//        System.out.println(solution("1S2D*3T"));
    }

    public static int solution(String dartResult) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        String[] s = dartResult.split("");
        System.out.println(Arrays.toString(s));

        int num = 0;
        int index = -1;
        for (int i = 0; i < s.length; i++) {
            if ("S".equals(s[i])) {

            } else if ("D".equals(s[i])) {
                num = list.remove(index);
                list.add(index, (int) Math.pow(num, 2));

            } else if ("T".equals(s[i])) {
                num = list.remove(index);
                list.add(index, (int) Math.pow(num, 3));

            } else if ("#".equals(s[i])) {
                num = list.remove(index);
                list.add(index, num * -1);

            } else if ("*".equals(s[i])) {
                num = list.remove(index);
                list.add(index, num * 2);

                if (index > 0) {
                    num = list.remove(index - 1);
                    list.add(index - 1, num * 2);
                }

            } else {
                if (index > -1 && "0".equals(s[i]) && "1".equals(s[i - 1])) {  // 10 처리
                    list.remove(index);
                    list.add(index, 10);
                } else {
                    list.add(Integer.parseInt(s[i]));
                    index++;
                }
            }
        }

        for (int i = 0; i < list.size(); i++) {
            answer += list.get(i);
        }

        return answer;
    }
}