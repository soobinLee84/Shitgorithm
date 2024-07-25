package LTC;

public class LTC5 {
    public String longestPalindrome(String s) {

        if (s.length() == 1)
            return s;

        String result = Character.toString(s.charAt(0));
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) != s.charAt(i + 1))
                continue;

            String a = aaa(s, i, i + 1);
            result = result.length() < a.length() ? a : result;
        }

        for (int i = 0; i < s.length() - 2; i++) {
            if (s.charAt(i) != s.charAt(i + 2))
                continue;

            String a = aaa(s, i, i + 2);
            result = result.length() < a.length() ? a : result;
        }

        return result;

    }

    public String aaa(String s, int start, int end) {

        do {
            if (s.charAt(start) == s.charAt(end)) {
                start--;
                end++;
            } else {
                break;
            }
        } while (start >= 0 && end < s.length());


        start++;
        end--;

        return s.substring(start, end + 1);
    }
}
