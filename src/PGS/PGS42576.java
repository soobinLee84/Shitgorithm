package PGS;

import java.util.Arrays;
import java.util.HashMap;

public class PGS42576 {

    public static void main(String[] args) {

        System.out.println(solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"}));
    }



    public static String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String s : participant) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for (String s : completion) {
            if (map.get(s) > 1) {
                map.put(s, map.get(s) - 1);
            } else {
                map.remove(s);
            }
        }

        return map.keySet().iterator().next();

    }

    public static String solution3(String[] participant, String[] completion) {

        Arrays.sort(participant);
        Arrays.sort(completion);

        int i = 0;
        while (i < completion.length) {
            if (!participant[i].equals(completion[i])) {
                return participant[i];
            }
            i++;
        }

        return participant[i];
    }
}
