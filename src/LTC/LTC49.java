package LTC;

import java.util.*;

public class LTC49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, Integer> indexMap = new HashMap<>();

        int listIndex = 0;
        List<List<String>> result = new ArrayList<>();

        for (int i = 0; i < strs.length; i++) {
            String[] sArr = strs[i].split("");
            Arrays.sort(sArr);
            String key = String.join("", sArr);
            Integer val = indexMap.get(key);

            if (val == null) {
                result.add(new ArrayList<>());
                indexMap.put(key, listIndex);
                val = listIndex;
                listIndex++;
            }

            result.get(val).add(strs[i]);
        }

        return result;
    }
}
