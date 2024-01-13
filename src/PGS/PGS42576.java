package PGS;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PGS42576 {

    public static void main(String[] args) {

    }

    public String solution(String[] participant, String[] completion) {

        List<String> list = Stream.of(completion).collect(Collectors.toList());

        for (int i = 0; i < participant.length; i++) {
            if (!list.remove(participant[i])) {
                return participant[i];
            }
        }

        return "";
    }
}
