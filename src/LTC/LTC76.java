package LTC;

import java.util.HashMap;
import java.util.Map;

public class LTC76 {
    public String minWindow(String s, String t) {

        Map<Character, Integer> counts = new HashMap<>();
        for (char c : t.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }
        int total = t.length();

        int left = 0, right = 0;
        int min = Integer.MAX_VALUE, minL = 0, minR = 0;

        for (char c : s.toCharArray()) {
            right++;

            // 있으면
            if (counts.containsKey(c) && counts.getOrDefault(c, 0) > 0) {
                total--;
            }

            counts.put(c, counts.getOrDefault(c, 0) - 1);

            if (total == 0) {
                while (left < right && counts.get(s.charAt(left)) < 0) {
                    counts.put(s.charAt(left), counts.get(s.charAt(left)) + 1);
                    left++;
                }

                if (right - left < min) {
                    min = right - left;
                    minL = left;
                    minR = right;
                }

                counts.put(s.charAt(left), counts.getOrDefault(s.charAt(left), 0) + 1);
                left++;
                total++;

            }
        }

        return s.substring(minL, minR);
    }
}
