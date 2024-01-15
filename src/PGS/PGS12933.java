package PGS;

import java.util.Arrays;
import java.util.Comparator;

public class PGS12933 {

    public static void main(String[] args) {
        System.out.println(solution(118372));
    }

    public static long solution(long n) {

        String[] nSplit = Long.toString(n).split("");
        Arrays.sort(nSplit, Comparator.reverseOrder());

        return Long.parseLong(String.join("", nSplit));
    }

}
