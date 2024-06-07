package LTC;

import java.util.HashMap;
import java.util.Map;

/**
 * 383. Ransom Note
 */
public class LTC383 {

    public boolean canConstruct(String ransomNote, String magazine) {

        if (ransomNote.length() > magazine.length())
            return false;

        int[] count = new int['z' - 'a' + 1];
        for (int i = 0; i < magazine.length(); i++) {
            count[magazine.charAt(i) - 'a']++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            if (count[ransomNote.charAt(i) - 'a'] == 0) return false;
            count[ransomNote.charAt(i) - 'a']--;
        }

        return true;
    }

    // 해시맵으로 처리했는데 속도가 느림
    public boolean canConstruct3(String ransomNote, String magazine) {

        if (ransomNote.length() > magazine.length())
            return false;

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {

            Character key = magazine.charAt(i);
            Integer count = map.getOrDefault(key, 0);
            map.put(key, count + 1);
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            Character key = ransomNote.charAt(i);
            Integer count = map.get(key);

            if (count == null || count == 0)
                return false;

            map.put(key, count - 1);
        }

        return true;
    }

    // 순서를 지켜야 한다면?
    public boolean canConstruct2(String ransomNote, String magazine) {

        int noteLength = ransomNote.length();
        if (noteLength > magazine.length())
            return false;

        System.out.println(magazine.length() + " " + noteLength);

        for (int i = 0; i <= (magazine.length() - noteLength); i++) {
            if (magazine.charAt(i) != ransomNote.charAt((0))) {
                continue;
            }

            if (ransomNote.equals(magazine.substring(i, i + noteLength))) {
                return true;
            }
        }

        return false;
    }
}
