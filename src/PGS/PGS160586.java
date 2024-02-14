package PGS;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PGS160586 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"ABACD", "BCEFD"}, new String[]{"ABCD", "AABB"})));
    }

    public static int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        Map<String, Integer> map = new HashMap<>();

        for (String k : keymap) {
            String[] s = k.split("");
            for (int j = 0; j < s.length; j++) {
                Integer value = map.getOrDefault(s[j], Integer.MAX_VALUE);
                map.put(s[j], Math.min(value, j + 1));
            }
        }

        for (int i = 0; i < targets.length; i++) {
            answer[i] = 0;
            String[] s = targets[i].split("");
            for (int j = 0; j < s.length; j++) {
                Integer value = map.get(s[j]);

                if (value == null) {
                    answer[i] = -1;
                    break;
                }

                answer[i] += value;
            }
        }

        return answer;
    }
}
