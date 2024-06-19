package LTC;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1122. Relative Sort Array
 */
public class LTC1122 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
            relativeSortArray(new int[]{28, 6, 22, 8, 44, 17},
                new int[]{22, 28, 8, 6})));
    }

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], i);
        }

        Integer[] newArr = new Integer[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            newArr[i] = arr1[i];
        }

        Arrays.sort(newArr, (a, b) -> {
            Integer aIndex = map.get(a);
            Integer bIndex = map.get(b);

            if (aIndex == null && bIndex == null) {
                return a - b;
            } else if (bIndex == null) {
                return -1;
            } else if (aIndex == null) {
                return 1;
            } else {
                return aIndex - bIndex;
            }
        });

        for (int i = 0; i < newArr.length; i++) {
            arr1[i] = newArr[i];
        }

        return arr1;
    }

}
