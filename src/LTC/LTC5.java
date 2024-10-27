package LTC;

public class LTC5 {

    /**
     * 시간복잡도 : O(n^2) / 공간복잡도 : O(1)
     */
    int start = 0, maxLen = 1;
    public String longestPalindrome(String s) {
        if (s.length() == 1) return s;

        for (int i = 0; i < s.length() - 1; i++) {
            expand(i, i, s);  //3칸짜리 뿌리의 팰린드롬
            expand(i, i + 1, s);  //2칸짜리 뿌리의 팰린드롬
        }

        return s.substring(start, start + maxLen);
    }

    private void expand(int left, int right, String s) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        left++;
        right--;

        if (maxLen < right - left + 1) {
            maxLen = right - left + 1;
            start = left;
        }
    }


    public String longestPalindrome2(String s) {

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
