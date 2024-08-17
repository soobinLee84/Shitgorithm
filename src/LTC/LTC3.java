package LTC;

import java.util.HashMap;
import java.util.Map;

public class LTC3 {

    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;

        if (s.isEmpty())
            return 0;
        if (s.length() == 1)
            return 1;

        int left = 0;
        int right = 0;

        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            // 슬라이딩 윈도우 안에 중복을 발견함
            if (map.containsKey(c) && map.get(c) >= left) {
                left = map.get(c) + 1;

            } else {  // 최대길이 계속 확인
                maxLength = Math.max(maxLength, right - left + 1);
            }

            map.put(c, right);
            right++;
        }

        return maxLength;
    }
}
