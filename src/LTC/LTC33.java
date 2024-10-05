package LTC;

public class LTC33 {

    public static void main(String[] args) {
        System.out.println(search(new int[]{3, 4, 5, 6, 0, 1, 2}, 0));
    }

    public static int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        int p = left;

        left = 0;
        right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midP = (mid + p) % nums.length;

            if (nums[midP] < target) {
                left = mid + 1;
            } else if (nums[midP] > target) {
                right = mid - 1;
            } else {
                return midP;
            }

        }

        return -1;

    }
}
