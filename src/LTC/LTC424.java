package LTC;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LTC424 {

    public int characterReplacement(String s, int k) {

        int[] counts = new int[26];
        int left = 0;
        int max = 0;

        for (int right = 1; right <= s.length(); right++) {
            counts[s.charAt(right - 1) - 'A']++;
            max = Math.max(max, counts[s.charAt(right - 1) - 'A']);

            if (right - left - max > k) {
                counts[s.charAt(left) - 'A']--;
                left++;
            }
        }

        return s.length() - left;
    }

    public int characterReplacement2(String s, int k) {

        int left = 0;
        Map<Character, Integer> counts = new HashMap<>();
        int maxCharCount = 0;

        for (int right = 1; right <= s.length(); right++) {
            counts.put(s.charAt(right - 1), counts.getOrDefault(s.charAt(right - 1), 0) + 1);
            maxCharCount = Math.max(maxCharCount, counts.get(s.charAt(right - 1)));


            // 대체값이 k개가 넘어가면 left 증가
            if (right - left - maxCharCount > k) {
                counts.put(s.charAt(left), counts.getOrDefault(s.charAt(left), 0) - 1);
                left++;
            }
        }

        return s.length() - left;
    }

}
