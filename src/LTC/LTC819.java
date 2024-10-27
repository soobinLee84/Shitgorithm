package LTC;

import java.util.HashMap;
import java.util.Map;

public class LTC819 {

    /**
     * 시간복잡도 : O(n) / 공간복잡도 : O(n)<br>
     * (단, n은 단어의 개수)
     *
     * @param paragraph
     * @param banned
     * @return
     */
    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> map = new HashMap<>();

        String[] str = paragraph.toLowerCase().split("[ !?',;.]+");
        for (String s : str) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for (String b : banned) {
            map.put(b, 0);
        }

        int max = 0;
        String result = "";
        for (String key : map.keySet()) {
            int val = map.get(key);
            if (val > max) {
                max = val;
                result = key;
            }
        }

        return result;
    }
}
