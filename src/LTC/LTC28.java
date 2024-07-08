package LTC;

/**
 * 28. Find the Index of the First Occurrence in a String
 */

public class LTC28 {
    public int strStr(String haystack, String needle) {

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            char h = haystack.charAt(i);
            if (h == needle.charAt(0)
                && needle.equals(haystack.substring(i, i + needle.length()))) {
                return i;
            }
        }

        return -1;
    }
}
