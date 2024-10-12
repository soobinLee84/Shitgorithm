package LTC;

import java.util.Arrays;

public class LTC455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0, j = 0; // g:i, s:j
        while (i < g.length && j < s.length) {

            if (s[j] >= g[i]) {
                i++;
            }
            j++;
        }

        return i;
    }
}
