package LTC;

public class LTC125 {

    /**
     * 투포인터로 문자열 전체 탐색
     * 시간복잡도 : O(n) / 공간복잡도 : O(1)
     *
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int left = 0, right = s.length() - 1;

        while (left < right) {
            while (left < s.length() && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (right > -1 && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            if (left >= right) {
                break;
            }

            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }

        }

        return true;
    }

    public boolean isPalindrome2(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        s = s.toLowerCase();

        // System.out.println(s);
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }

        return true;
    }
}
