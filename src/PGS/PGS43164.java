package PGS;

import java.util.*;

public class PGS43164 {

    public String[] solution(String[][] tickets) {

        List<String> result = new LinkedList<>();
        Map<String, PriorityQueue<String>> map = new HashMap<>();

        // 여행지 정리
        for (String[] t : tickets) {
            map.putIfAbsent(t[0], new PriorityQueue<>());
            map.get(t[0]).add(t[1]);
        }

        dfs(result, map, "ICN");

        return result.toArray(new String[0]);
    }

    public void dfs(List<String> result, Map<String, PriorityQueue<String>> map, String c) {
        while (map.containsKey(c) && !map.get(c).isEmpty()) {
            dfs(result, map, map.get(c).poll());
        }

        // 도착지부터 저장
        result.add(0, c);
    }
}
