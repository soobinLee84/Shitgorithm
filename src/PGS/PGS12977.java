package PGS;

public class PGS12977 {
    public static void main(String[] args) {
//        System.out.println(solution(new int[]{1, 2, 3, 4}));
        System.out.println(solution(new int[]{1, 2, 7, 6, 4}));
    }

    public static int solution(int[] nums) {
        int answer = 0;

        for (int i = 0; i <= nums.length - 3; i++) {
            answer += fac_sum(nums, i + 1, 1, nums[i]);
        }

        return answer;
    }

    public static int fac_sum(int[] nums, int index, int count, int sum) {
        if (count >= 3) {
            return isPrime(sum);
        }

        if (index >= nums.length) {
            return 0;
        }

        return fac_sum(nums, index + 1, count + 1, sum + nums[index])
                + fac_sum(nums, index + 1, count, sum);
    }

    // 소수 : 1, 아님 : 0
    public static int isPrime(int n) {

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return 0;
        }

        return 1;
    }
}
