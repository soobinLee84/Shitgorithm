package LTC;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LTC56 {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> merged = new ArrayList<>();
        for (int[] i : intervals) {
            if (!merged.isEmpty() && i[0] <= merged.get(merged.size() - 1)[1]) {
                merged.get(merged.size() - 1)[1] = Math.max(i[1], merged.get(merged.size() - 1)[1]);
            } else {
                merged.add(i);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}
