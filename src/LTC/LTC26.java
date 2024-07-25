package LTC;

/**
 * 26. Remove Duplicates from Sorted Array
 */

public class LTC26 {

    public int removeDuplicates(int[] nums) {

        int save = 1;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] != nums[i - 1]) {
                nums[save++] = nums[i];
            }
        }

        return save;
    }
}
