package LTC;

/**
 * 1480. Running Sum of 1d Array
 */
public class LTC1480 {

    public int[] runningSum1(int[] nums) {

        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }

        return nums;
    }

    public int[] runningSum2(int[] nums) {
        int[] result = new int[nums.length];

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            result[i] = sum;
        }

        return result;
    }

}
