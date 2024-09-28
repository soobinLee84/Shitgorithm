package LTC;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LTC242 {

    public boolean isAnagram(String s, String t) {
        int[] arr = new int[26];

        for (char c : s.toCharArray()) {
            arr[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            arr[c - 'a']--;
        }

        for (int i : arr) {
            if (i != 0) return false;
        }

        return true;
    }

    public boolean isAnagram1(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            if (!map.containsKey(c)) {
                return false;
            }

            int val = map.get(c);
            if (val == 1) {
                map.remove(c);
            } else {
                map.put(c, val - 1);
            }
        }

        return map.isEmpty();
    }

    public boolean isAnagram2(String s, String t) {

        String[] sArr = s.split("");
        Arrays.sort(sArr);

        String[] tArr = t.split("");
        Arrays.sort(tArr);

        return String.join("", sArr).equals(String.join("", tArr));
    }
}
