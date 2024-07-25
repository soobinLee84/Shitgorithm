package LTC;

public class LTC238 {
    public int[] productExceptSelf(int[] nums) {

        int[] result = new int[nums.length];

        float total = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = (int) total;
            total *= nums[i];
        }

        total = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= total;
            total *= nums[i];
        }

        return result;
    }
}
