package PGS;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class PGS150370 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("2022.05.19",
                new String[]{"A 6", "B 12", "C 3"},
                new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"})));
    }

    public static int[] solution(String today, String[] terms, String[] privacies) {
        LocalDate todayDate = LocalDate.parse(today, DateTimeFormatter.ofPattern("yyyy.MM.dd"));

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < terms.length; i++) {
            String[] s = terms[i].split(" ");
            map.put(s[0], Integer.parseInt(s[1]));
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            String[] s = privacies[i].split(" ");
            LocalDate pDay = LocalDate.parse(s[0], DateTimeFormatter.ofPattern("yyyy.MM.dd"));
            LocalDate expirationDate = pDay.plusMonths(map.get(s[1])).minusDays(1);
            /*LocalDate maxDate = LocalDate.of(expirationDate.getYear(), expirationDate.getMonth(), 28);
            if (expirationDate.isAfter(maxDate)) {
                expirationDate = maxDate;
            }*/

            if (todayDate.isAfter(expirationDate)) {
                list.add(i + 1);
            }
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

}
