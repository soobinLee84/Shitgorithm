package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class BOJ2468 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] grid = new int[n][n];


        Set<Integer> nums = new TreeSet<>(Comparator.reverseOrder());
        for (int i = 0; i < grid.length; i++) {
            String[] i2 = br.readLine().split(" ");
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = Integer.parseInt(i2[j]);
                nums.add(grid[i][j]);
            }
        }

        /*for (int[] g : grid) {
            System.out.println(Arrays.toString(g));
        }*/

        Iterator<Integer> it = nums.iterator();

        int result = 1;
        while (it.hasNext()) {
            int round = it.next();
            int count = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] >= round) {
                        dfs(grid, round, i, j);
                        count++;
                    }
                }
            }

            result = Math.max(result, count);
        }

        System.out.println(result);
    }

    private static void dfs(int[][] grid, int round, int i, int j) {

        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] < round) {
            return;
        }

        grid[i][j] = round - 1;

        dfs(grid, round, i + 1, j);
        dfs(grid, round, i - 1, j);
        dfs(grid, round, i, j + 1);
        dfs(grid, round, i, j - 1);
    }
}
