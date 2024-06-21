package LTC;

import java.util.HashMap;
import java.util.Map;

/**
 * 13. Roman to Integer
 */
public class LTC13 {

    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        char[] arr = s.toCharArray();
        int before = map.get(arr[0]);
        int now = 0;
        int result = 0;
        for (int i = 1; i < arr.length; i++) {
            now = map.get(arr[i]);
            if (before < now) {
                before = now - before;
            } else {
                result += before;
                before = now;
            }
        }

        result += before;

        return result;
    }
}