package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ3197 {

    static class Position {
        int r;
        int c;

        public Position(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] a = br.readLine().split(" ");

        int r = Integer.parseInt(a[0]);
        int c = Integer.parseInt(a[1]);

        String[] input = new String[r];
        for (int i = 0; i < r; i++) {
            input[i] = br.readLine();
        }

        int[][] area = new int[r][c];  //지형
        int l = -1;
        int[] lPosition = new int[2];
        int count = 0; // 얼음 녹는 날
        Queue<Position> water = new LinkedList<>();

        //지형 설정
        for (int i = 0; i < area.length; i++) {
            String[] split = input[i].split("");
            for (int j = 0; j < area[i].length; j++) {
                if (".".equals(split[j])) {  //물
                    area[i][j] = 10;
                    water.add(new Position(i, j));
                } else if ("X".equals(split[j])) {  //얼음
                    area[i][j] = 1;
                } else {  //L
                    water.add(new Position(i, j));
                    area[i][j] = l++;
                    lPosition[0] = i;
                    lPosition[1] = j;
                }
            }
        }

        while (true) {
            removeIce(area, water, ++count);
            if (water.isEmpty())
                break;
        }

        boolean[][] check = new boolean[r][c];  //백조찾기
        System.out.println(findL(area, check, lPosition[0], lPosition[1]) - 10);
    }

    public static void removeIce(int[][] area, Queue<Position> water, int count) {
        water.add(null);

        while (true) {
            Position waterPosition = water.remove();

            if (waterPosition == null) break;

            int i = waterPosition.r;
            int j = waterPosition.c;

            if (i > 0 && area[i - 1][j] == 1) { //위
                water.add(new Position(i - 1, j));
                area[i - 1][j] = 10 + count;
            }
            if (i < area.length - 1 && area[i + 1][j] == 1) { //아래
                water.add(new Position(i + 1, j));
                area[i + 1][j] = 10 + count;
            }
            if (j > 0 && area[i][j - 1] == 1) { //왼쪽
                water.add(new Position(i, j - 1));
                area[i][j - 1] = 10 + count;
            }
            if (j < area[i].length - 1 && area[i][j + 1] == 1) { //오른쪽
                water.add(new Position(i, j + 1));
                area[i][j + 1] = 10 + count;
            }

        }

    }

    public static int findL(int[][] area, boolean[][] check, int li, int lj) {
        return rec_findL(area, check, li, lj, 0);
    }

    public static int rec_findL(int[][] area, boolean[][] check, int li, int lj, int max) {

        if (li < 0 || li >= area.length || lj < 0 || lj >= area[0].length) { //범위초과
            return Integer.MAX_VALUE;
        }

        if (area[li][lj] == 1) { //벽
            return Integer.MAX_VALUE;
        }

        if (area[li][lj] == -1) { //백조
            return max;
        }

        if (check[li][lj])  //한번 들른 곳은 멈춰~
            return Integer.MAX_VALUE;
        check[li][lj] = true;

        int nowMax = Math.max(area[li][lj], max);

        List<Integer> intList = Arrays.asList(
                rec_findL(area, check, li - 1, lj, nowMax),
                rec_findL(area, check, li + 1, lj, nowMax),
                rec_findL(area, check, li, lj - 1, nowMax),
                rec_findL(area, check, li, lj + 1, nowMax));
        return Collections.min(intList);
    }

}