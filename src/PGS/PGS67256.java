package PGS;

public class PGS67256 {
    public static void main(String[] args) {
//        System.out.println(solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right"));
//        System.out.println(solution(new int[]{3, 7, 5, 2}, "left"));
        System.out.println(solution(new int[]{2, 5, 8, 0}, "right"));
    }

    public static String solution(int[] numbers, String hand) {
        int[] h = new int[]{"left".equals(hand) ? 1 : 2, 11, 11, 1, 1};  //주손, 왼쪽, 오른쪽
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numbers.length; i++) {
            int n = numbers[i];
            if (n == 1 || n == 4 || n == 7) {
                h[1] = n + 1;
                h[3] = 1;
                sb.append("L");
            } else if (n == 3 || n == 6 || n == 9) {
                h[2] = n - 1;
                h[4] = 1;
                sb.append("R");
            } else {
                if (n == 0)
                    n = 11;

                int i1 = (Math.abs(n - h[1]) / 3 + h[3]) - (Math.abs(n - h[2]) / 3 + h[4]);
                if (i1 == 0) {
                    h[h[0]] = n;
                    h[h[0] + 2] = 0;
                    sb.append(h[0] == 1 ? "L" : "R");
                } else if (i1 > 0) {
                    h[2] = n;
                    h[4] = 0;
                    sb.append("R");
                } else {
                    h[1] = n;
                    h[3] = 0;
                    sb.append("L");
                }
            }
            System.out.println((h[1] - h[3]) + " " + (h[2] + h[4]) + " " + sb);
        }
        return sb.toString();
    }
}
