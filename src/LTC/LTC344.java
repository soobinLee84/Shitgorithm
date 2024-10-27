package LTC;

public class LTC344 {

    /**
     * 시간복잡도 : O(n) / 공간복잡도 : O(1)
     *
     * @param s
     */
    public static void reverseString2(char[] s) {

        int left = 0, right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
    }

    public void reverseString(char[] s) {

        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp;
        }
    }
}
