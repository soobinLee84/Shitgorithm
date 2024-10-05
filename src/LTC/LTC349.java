package LTC;

import java.util.*;

public class LTC349 {

    /**
     * 기본
     */
    public int[] intersection(int[] nums1, int[] nums2) {

        boolean[] set = new boolean[1001];
        for (int n : nums1) {
            set[n] = true;
        }

        List<Integer> list = new ArrayList<>();
        for (int n : nums2) {
            if (set[n]) {
                list.add(n);
                set[n] = false;
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

//        list.stream().mapToInt(Integer::intValue).toArray();

        return result;
    }

    /**
     * 이진 검색
     */
    public int[] intersection2(int[] nums1, int[] nums2) {

        Set<Integer> set = new HashSet<>();

        Arrays.sort(nums2);

        for (int n : nums1) {
            if (Arrays.binarySearch(nums2, n) > -1) {
                set.add(n);
            }
        }

        return set.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * 투포인터
     */
    public int[] intersection3(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0;
        int j = 0;
        Set<Integer> set = new HashSet<>();

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                set.add(nums1[i]);
                i++;
                j++;
            }
        }

        return set.stream().mapToInt(Integer::intValue).toArray();
    }
}
