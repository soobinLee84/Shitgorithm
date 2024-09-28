package LTC;

public class LTC75 {
    public void sortColors(int[] nums) {
        int r = 0;
        int w = 0;
        int b = nums.length;

        while (w < b) {
            if (nums[w] < 1) {
                int t = nums[w];
                nums[w] = nums[r];
                nums[r] = t;

                r++;
                w++;

            } else if (nums[w] > 1) {
                b--;

                int t = nums[w];
                nums[w] = nums[b];
                nums[b] = t;

            } else {
                w++;
            }
        }
    }
}
