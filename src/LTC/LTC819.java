package LTC;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LTC819 {
    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> map = new HashMap<>();

        String[] str = paragraph
                .split("[ !?',;.]+");

        System.out.println(Arrays.toString(str));

        int maxCount = 0;
        String v = "";

        for (String s : str) {
            int value = map.getOrDefault(s.toLowerCase(), 0) + 1;
            map.put(s.toLowerCase(), value);

        }

        for (String b : banned) {
            map.put(b, 0);
        }

        System.out.println(map);

        int max = 0;
        String result = "";
        for (String key : map.keySet()) {
            if (map.get(key) > max) {
                max = map.get(key);
                result = key;
            }

        }

        return result;
    }
}
