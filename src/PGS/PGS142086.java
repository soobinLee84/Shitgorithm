package PGS;

import java.util.Arrays;

public class PGS142086 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("banana")));
    }

    public static int[] solution(String s) {
        int[] n = new int['z' - 'a' + 1];
        Arrays.fill(n, -1);

        int[] answer = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            answer[i] = n[s.charAt(i) - 'a'] == -1 ? -1 : i - n[s.charAt(i) - 'a'];
            n[s.charAt(i) - 'a'] = i;
        }

        return answer;
    }
}
