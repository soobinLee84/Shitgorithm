package LTC;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LTC167 {

    /**
     * 투포인터
     */
    public int[] twoSum2(int[] n, int target) {

        int left = 0;
        int right = n.length - 1;

        while (left != right) {

            if (n[left] + n[right] < target) {
                left++;
            } else if (n[left] + n[right] > target) {
                right--;
            } else {
                return new int[]{left + 1, right + 1};

            }
        }

        return null;
    }

    /**
     * Map
     */
    public int[] twoSum(int[] numbers, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(numbers[i])) {
                return new int[]{map.get(numbers[i]) + 1, i + 1};
            } else {
                map.put(target - numbers[i], i);
            }
        }

        return null;
    }

    /**
     * 이진 검색 메소드
     */
    public int[] twoSum3(int[] n, int target) {

        for (int i = 0; i < n.length; i++) {
            int ex = target - n[i];

            int i2 = Arrays.binarySearch(n, i + 1, n.length, ex);

            if (i2 > -1) {
                return new int[]{i + 1, i2 + 1};
            }
        }

        return null;
    }
}
