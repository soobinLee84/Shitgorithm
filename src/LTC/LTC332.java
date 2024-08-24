package LTC;

import java.util.*;

public class LTC332 {
    public List<String> findItinerary(List<List<String>> tickets) {

        List<String> result = new LinkedList<>();
        Map<String, PriorityQueue<String>> map = new HashMap<>();

        // 여행지 정리
        for (List<String> t : tickets) {
            map.putIfAbsent(t.get(0), new PriorityQueue<>());
            map.get(t.get(0)).add(t.get(1));
        }

        dfs(result, map, "JFK");

        return result;
    }

    /**
     * @param result 결과
     * @param map    정보
     * @param c      탐색조건
     */
    public void dfs(List<String> result, Map<String, PriorityQueue<String>> map, String c) {

        while (map.containsKey(c) && !map.get(c).isEmpty()) {
            dfs(result, map, map.get(c).poll());
        }

        // 도착지부터 저장
        result.add(0, c);
    }
}
