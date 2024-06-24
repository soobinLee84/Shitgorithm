package LTC;

import java.util.Arrays;

/**
 * 14. Longest Common Prefix
 */
public class LTC14 {

    /**
     * 정렬 후 처음과 마지막 문자만 확인
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {

        if (strs.length == 1) {
            return strs[0];
        }

        Arrays.sort(strs);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            if (strs[0].charAt(i) != strs[strs.length - 1].charAt(i)) {
                break;
            }
            sb.append(c);
        }

        return sb.toString();
    }

    /**
     * 수직 스캔
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix2(String[] strs) {

        if (strs.length == 1) {
            return strs[0];
        }

        StringBuilder sb = new StringBuilder();

        loop1:
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);

            try {
                loop2:
                for (int j = 1; j < strs.length; j++) {
                    if (c != strs[j].charAt(i)) {
                        break loop1;
                    }
                }

            } catch (IndexOutOfBoundsException e) {
                break;
            }

            sb.append(c);
        }

        return sb.toString();
    }

}
