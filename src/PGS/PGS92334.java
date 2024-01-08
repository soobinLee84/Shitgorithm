package PGS;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class PGS92334 {

    public static void main(String[] args) {

        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;

        System.out.println(Arrays.toString(solution(id_list, report, k)));
    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        Arrays.stream(report).distinct().collect(Collectors.toList());

        Map<String, Integer> idIndex = new HashMap<>();
        for (int i = 0; i < id_list.length; i++) {
            idIndex.put(id_list[i], i);
        }

        // <신고받은 사람, 신고한사람들>
        Map<String, Set<String>> reported = new HashMap<>();
        for (int i = 0; i < report.length; i++) {
            String[] splitReported = report[i].split(" ");

            Set<String> set = reported.getOrDefault(splitReported[1], new HashSet<>());
            set.add(splitReported[0]);
            reported.put(splitReported[1], set);
        }

        for (String key : reported.keySet()) {
            if (reported.get(key).size() < k) {
                continue;
            }

            for (String r : reported.get(key)) {
                answer[idIndex.get(r)]++;
            }
        }

        return answer;
    }
}
