package LTC;

/**
 * 1342. Number of Steps to Reduce a Number to Zero
 */
public class LTC1342 {

    public int numberOfSteps2(int num) {

        if (num == 0)
            return 0;
        if (num == 1)
            return 1;

        String bin = Integer.toBinaryString(num);
        int result = 1;
        for (int i = 1; i < bin.length(); i++) {
            if (bin.charAt(i) == '1') {
                result++;
            }
            result++;
        }

        return result;
    }

    public int numberOfSteps(int num) {

        if (num == 0)
            return 0;
        if (num == 1)
            return 1;

        int result = 1;

        while (num > 1) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num -= 1;
            }
            result++;
        }

        return result;
    }
}
