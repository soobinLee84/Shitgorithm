package LTC;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. Two Sum
 */
public class LTC1 {

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            Integer val = map.get(target - nums[i]);

            if (val == null) {
                map.put(nums[i], i);
            } else {
                return new int[]{i, val};
            }
        }

        return new int[2];

    }

    public int[] twoSum2(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                //System.out.println(i+" "+j);
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[2];
    }
}
