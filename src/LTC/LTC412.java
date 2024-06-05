package LTC;

import java.util.ArrayList;
import java.util.List;

/**
 * 412. Fizz Buzz
 */
public class LTC412 {

    public List<String> fizzBuzz(int n) {
        List<String> answer = new ArrayList<>();

        for (int i = 1; i < n + 1; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                answer.add("FizzBuzz");
            } else if (i % 3 == 0) {
                answer.add("Fizz");
            } else if (i % 5 == 0) {
                answer.add("Buzz");
            } else {
                answer.add(Integer.toString(i));
            }
        }

        return answer;

    }
}
