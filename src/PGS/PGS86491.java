package PGS;

public class PGS86491 {

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{60, 50}, {30, 70}, {60, 30}, {80, 40}}));  //4000
        System.out.println(
            solution(new int[][]{{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}}));  //120
    }

    public static int solution(int[][] sizes) {
        int a = Integer.MIN_VALUE;
        int b = Integer.MIN_VALUE;

        for (int i = 0; i < sizes.length; i++) {
            a = Math.max(a, Math.min(sizes[i][0], sizes[i][1]));
            b = Math.max(b, Math.max(sizes[i][0], sizes[i][1]));
        }

        return a * b;
    }
}
