package LTC;

import java.util.Arrays;

public class LTC179 {

    public static void main(String[] args) {
        largestNumber(new int[]{12, 22, 3});
    }

    public static String largestNumber(int[] nums) {

        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));

        if (arr[0].equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s);
        }

        return sb.toString();
    }


    public String largestNumber2(int[] nums) {

        int i = 1;
        while (i < nums.length) {
            int j = i;
            while (j > 0 && toSwap(nums[j - 1], nums[j])) {
                int t = nums[j];
                nums[j] = nums[j - 1];
                nums[j - 1] = t;

                j++;
            }

            i++;
        }

        if (nums[0] == 0) return "0";
        else return Arrays.toString(nums).replaceAll("^\\d", "");
    }

    private boolean toSwap(int a, int b) {
        return Long.parseLong(String.valueOf(a) + b) < Long.parseLong(String.valueOf(b) + a);
    }
}
