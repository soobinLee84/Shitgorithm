package LTC;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LTC17 {

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if (digits.isEmpty()) return result;

        // 자판
        Map<Character, List<Character>> letter = new HashMap<>();
        letter.put('2', List.of('a', 'b', 'c'));
        letter.put('3', List.of('d', 'e', 'f'));
        letter.put('4', List.of('g', 'h', 'i'));
        letter.put('5', List.of('j', 'k', 'l'));
        letter.put('6', List.of('m', 'n', 'o'));
        letter.put('7', List.of('p', 'q', 'r', 's'));
        letter.put('8', List.of('t', 'u', 'v'));
        letter.put('9', List.of('w', 'x', 'y', 'z'));

        dfs(result, letter, digits, 0, new StringBuilder());

        return result;
    }

    /**
     * @param result 결과
     * @param letter 정보
     * @param digits 탐색조건
     * @param index  종료조건
     * @param path   경로
     */
    public void dfs(List<String> result, Map<Character, List<Character>> letter,
                    String digits, int index, StringBuilder path) {

        // 종료
        if (index == digits.length()) {
            result.add(path.toString());
            return;
        }

        // 자판문자 탐색
        for (Character c : letter.get(digits.charAt(index))) {
            // 경로를 넣고 빼기를 안하기 위해 new StringBuilder 사용
            dfs(result, letter, digits, index + 1, new StringBuilder(path).append(c));
        }

    }
}
