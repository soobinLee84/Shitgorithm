package LTC;

/**
 * 9. Palindrome Number
 */
public class LTC9 {

    // O(N)
    public boolean isPalindrome2(int x) {
        String s = Integer.toString(x);
        System.out.println(s);

        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }

        return true;
    }
}
