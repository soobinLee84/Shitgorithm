package LTC;

public class LTC53 {
    public int maxSubArray(int[] nums) {
        int curSum = 0, maxSum = nums[0];

        for (int n : nums) {
            curSum = Math.max(n, curSum + n);
            maxSum = Math.max(curSum, maxSum);
        }

        return maxSum;
    }
}
