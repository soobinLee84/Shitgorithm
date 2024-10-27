package LTC;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LTC937 {

    /**
     * 시간복잡도 : O(nlogn) / 공간복잡도 : O(n)
     * @param logs
     * @return
     */
    public String[] reorderLogFiles(String[] logs) {
        List<String> letter = new ArrayList<>();
        List<String> digit = new ArrayList<>();

        for (String log : logs) {
            if (Character.isDigit(log.split(" ")[1].charAt(0))) {
                digit.add(log);
            } else {
                letter.add(log);
            }
        }

        letter.sort((a, b) -> {
            String[] aSplit = a.split(" ", 2);
            String[] bSplit = b.split(" ", 2);

            int c = aSplit[1].compareTo(bSplit[1]);
            if (c == 0) {
                return aSplit[0].compareTo(bSplit[0]);
            }
            return c;
        });

        letter.addAll(digit);
        return letter.toArray(new String[0]);
    }
}
