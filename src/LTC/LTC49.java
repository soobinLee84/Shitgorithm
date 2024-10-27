package LTC;

import java.util.*;

public class LTC49 {

    /**
     * 시간복잡도 : O(n*mlogm) / 공간복잡도 : O(nm)<br>
     * (단, n은 strs의 길이, m은 strs[i]의 길이
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> anagrams = new HashMap<>();

        for (String s : strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String sortedString = String.valueOf(c);  // 정렬된 문자열

            anagrams.putIfAbsent(sortedString, new ArrayList<>());
            anagrams.get(sortedString).add(s);
        }

        return new ArrayList<>(anagrams.values());
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
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
