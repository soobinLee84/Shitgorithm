package LTC;

import java.util.Arrays;
import java.util.Comparator;

public class LTC1235 {

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

        int jobsLen = startTime.length;

        Job[] jobs = new Job[jobsLen];
        for (int i = 0; i < startTime.length; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }

        Arrays.sort(jobs, Comparator.comparingInt(j -> j.endTime));

        int[] dp = new int[jobsLen + 1];
        for (int i = 0; i < jobsLen; ++i) {
            int j = search(jobs, i, jobs[i].startTime);
            dp[i + 1] = Math.max(dp[i], dp[j] + jobs[i].profit);
        }

        return dp[jobsLen];

    }

    private int search(Job[] jobs, int endIndex, int targetTime) {
        int left = 0;
        int right = endIndex;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (jobs[mid].endTime <= targetTime) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    private static class Job {

        int startTime;
        int endTime;
        int profit;

        public Job(int startTime, int endTime, int profit) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.profit = profit;
        }

    }
}
