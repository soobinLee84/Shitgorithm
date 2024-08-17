package LTC;

import java.util.HashSet;
import java.util.Set;

public class LTC771 {
    public int numJewelsInStones(String jewels, String stones) {

        Set<Character> set = new HashSet<>();

        for (char c : jewels.toCharArray()) {
            set.add(c);
        }

        int result = 0;
        for (char c : stones.toCharArray()) {
            if (set.contains(c)) {
                result++;
            }
        }

        return result;

    }

}
