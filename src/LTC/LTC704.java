package LTC;

import java.util.Arrays;

public class LTC704 {

    public int search(int[] nums, int target) {
        return Arrays.binarySearch(nums, target) > -1 ? Arrays.binarySearch(nums, target) : -1;
    }


    /**
     * 반복문 구현
     */
    public int search3(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] < target) {
                start = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }


    /**
     * 재귀 구현
     */
    public int search2(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    public int binarySearch(int[] nums, int target, int start, int end) {

        if (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] < target) {
                return binarySearch(nums, target, mid + 1, end);
            } else if (nums[mid] > target) {
                return binarySearch(nums, target, start, mid - 1);
            }

            return mid;

        } else {
            return -1;
        }

    }

}
