package LTC;

import java.util.ArrayList;
import java.util.List;

public class LTC937 {
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

            if (aSplit[1].equals(bSplit[1])) {
                return aSplit[0].compareTo(bSplit[0]);
            } else {
                return aSplit[1].compareTo(bSplit[1]);
            }

        });

        String[] result = new String[logs.length];

        int index = 0;

        for (String l : letter) {
            result[index++] = l;
        }

        for (String d : digit) {
            result[index++] = d;
        }

        return result;
    }
}
