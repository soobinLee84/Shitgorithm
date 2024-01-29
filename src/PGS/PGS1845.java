package PGS;

import java.util.HashSet;
import java.util.Set;

public class PGS1845 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 1, 2, 3}));
    }

    public static int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return Math.min(nums.length / 2, set.size());
    }
}
