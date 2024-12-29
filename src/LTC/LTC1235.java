package LTC;

import java.util.*;

public class LTC1235 {


    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

        Job[] jobs = new Job[endTime.length];
        for (int i = 0; i < startTime.length; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }

        Arrays.sort(jobs, Comparator.comparingInt(job -> job.endTime));

        int[] dp = new int[jobs.length + 1];



        return 0;
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
