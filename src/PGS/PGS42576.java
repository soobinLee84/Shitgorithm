package PGS;

import java.util.Arrays;

public class PGS42576 {

    public static void main(String[] args) {

        System.out.println(solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"}));
    }

    public static String solution(String[] participant, String[] completion) {

        Arrays.sort(participant);
        Arrays.sort(completion);

        int i = 0;
        while (i < completion.length) {
            if (!participant[i].equals(completion[i])) {
                return participant[i];
            }
            i++;
        }

        return participant[i];
    }
}
