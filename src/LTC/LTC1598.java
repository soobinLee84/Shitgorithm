package LTC;

/**
 * 1598. Crawler Log Folder
 */

public class LTC1598 {

    public int minOperations(String[] logs) {
        int result = 0;

        for (String log : logs) {
            if ("../".equals(log)) {
                result = result == 0 ? 0 : result - 1;
            } else if (!"./".equals(log)) {
                result++;
            }
        }

        return result;
    }
}
