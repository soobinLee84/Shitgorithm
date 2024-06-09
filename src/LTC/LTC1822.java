package LTC;

/**
 * 1822. Sign of the Product of an Array
 * 실제 곱셈 결과는 필요없다!
 */
public class LTC1822 {

    public int arraySign(int[] nums) {

        int answer = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                return 0;
            } else if (nums[i] < 0) {
                answer *= -1;
            }
        }

        if (answer > 0) {
            return 1;
        } else {
            return -1;
        }

    }
}
