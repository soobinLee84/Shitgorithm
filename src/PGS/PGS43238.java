package PGS;

import java.util.Arrays;

public class PGS43238 {

    public long solution(int n, int[] times) {
        long answer = 0;

        long left = 1;  // 최소 1명 1분
        long right = (long) Arrays.stream(times).max().getAsInt() * n;  // 최대 max분 n명

        long mid = right;
        while (left <= right) {

            long cal = 0;
            for (int t : times) {
                cal += (mid / t);
            }

            if (cal < n) {
                left = mid + 1;
            } else if (cal >= n) {
                answer = mid;
                right = mid - 1;
            }

            mid = left + (right - left) / 2;
        }

        return answer;
    }
}
