package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ3197 {

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


        //지형 설정
        for (int i = 0; i < area.length; i++) {
            String[] split = input[i].split("");
            for (int j = 0; j < area[i].length; j++) {
                if (".".equals(split[j])) {  //물
                    area[i][j] = 10;
                } else if ("X".equals(split[j])) {  //얼음
                    area[i][j] = 1;
                } else {  //L
                    area[i][j] = l++;
                    lPosition[0] = i;
                    lPosition[1] = j;
                }
            }
        }

        boolean isFindL = false;
        while (true) {
            boolean[][] check = new boolean[r][c];  //백조찾기
            isFindL = findL(area, check, lPosition[0], lPosition[1]);
            if (isFindL) break;
            removeIce(area, ++count);
        }

        System.out.println(count);
    }

    public static void removeIce(int[][] area, int count) {
        for (int i = 0; i < area.length; i++) {
            for (int j = 0; j < area[i].length; j++) {
                if (area[i][j] == (10 + count - 1)) {  //오늘치 물일 때

                    if (i > 0 && area[i - 1][j] == 1) { //위
                        area[i - 1][j] = 10 + count;
                    }
                    if (i < area.length - 1 && area[i + 1][j] == 1) { //아래
                        area[i + 1][j] = 10 + count;
                    }
                    if (j > 0 && area[i][j - 1] == 1) { //왼쪽
                        area[i][j - 1] = 10 + count;
                    }
                    if (j < area[i].length - 1 && area[i][j + 1] == 1) { //오른쪽
                        area[i][j + 1] = 10 + count;
                    }

                }
            }
        }
    }


    public static boolean findL(int[][] area, boolean[][] check, int li, int lj) {
        return rec_findL(area, check, li, lj);
    }

    public static boolean rec_findL(int[][] area, boolean[][] check, int li, int lj) {

        if (li < 0 || li >= area.length || lj < 0 || lj >= area[0].length) { //범위초과
            return false;
        }

        if (area[li][lj] == 1) { //벽
            return false;
        }

        if (area[li][lj] == -1) { //백조
            return true;
        }

        if (check[li][lj])  //한번 들린곳은 멈춰~
            return false;

        check[li][lj] = true;
        return rec_findL(area, check, li - 1, lj) || rec_findL(area, check, li + 1, lj)
                || rec_findL(area, check, li, lj - 1) || rec_findL(area, check, li, lj + 1);
    }

}