package PGS;

import java.util.HashMap;
import java.util.Map;

public class PGS118666 {
    public static void main(String[] args) {
        System.out.println(
                solution(new String[]{"AN", "CF", "MJ", "RT", "NA"},
                        new int[]{5, 3, 2, 7, 5}));  //TCMA
    }

    public static String solution(String[] survey, int[] choices) {
        String answer = "";
        int[] point = new int[]{0, 3, 2, 1, 0, 1, 2, 3};

        Map<Character, Integer> map = new HashMap<>();
        map.put('R', 0);
        map.put('T', 0);
        map.put('C', 0);
        map.put('F', 0);
        map.put('J', 0);
        map.put('M', 0);
        map.put('A', 0);
        map.put('N', 0);

        for (int i = 0; i < survey.length; i++) {
            int index = choices[i] < 4 ? 0 : 1;
            Character target = survey[i].charAt(index);
            map.put(target, map.get(target) + point[choices[i]]);
            System.out.println(map);
        }

        answer += map.get('R') < map.get('T') ? "T" : "R";
        answer += map.get('C') < map.get('F') ? "F" : "C";
        answer += map.get('J') < map.get('M') ? "M" : "J";
        answer += map.get('A') < map.get('N') ? "N" : "A";

        return answer;
    }
}
