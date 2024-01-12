package PGS;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class PGS68644 {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(solution(new int[]{2, 1, 3, 4, 1})));
        System.out.println(Arrays.toString(solution(new int[]{5, 0, 2, 7})));
    }

    public static int[] solution(int[] numbers) {
        Set<Integer> set = new TreeSet<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        int[] answer = new int[set.size()];
        int i = 0;
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            answer[i++] = it.next();
        }

        return answer;
    }
}
