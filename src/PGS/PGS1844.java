package PGS;

import java.util.*;

public class PGS1844 {

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}
        }));

    }

    // 우선순위 큐 (행, 열, 거리)
    static Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));

    public static int solution(int[][] maps) {
        pq.add(new int[]{0, 0, 1});  // 시작지점

        Map<Integer, int[]> result = new HashMap<>();

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            if (!result.containsKey(cur[0] * 1000 + cur[1])) {
                result.put(cur[0] * 1000 + cur[1], cur);

                findPath(cur[0] + 1, cur[1], cur[2], maps);
                findPath(cur[0] - 1, cur[1], cur[2], maps);
                findPath(cur[0], cur[1] + 1, cur[2], maps);
                findPath(cur[0], cur[1] - 1, cur[2], maps);
            }

        }

        // 마지막 칸의 거리 조회
        if (result.containsKey((maps.length - 1) * 1000 + maps[0].length - 1)) {
            return result.get((maps.length - 1) * 1000 + maps[0].length - 1)[2];
        }

        System.out.println(result);

        return -1;
    }

    private static void findPath(int x, int y, int d, int[][] maps) {
        if (x >= 0 && x < maps.length && y >= 0 && y < maps[x].length && maps[x][y] == 1) {
            maps[x][y] = 0;
            pq.add(new int[]{x, y, d + 1});
        }
    }
}
