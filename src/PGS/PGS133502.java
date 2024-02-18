package PGS;

import java.util.Arrays;

public class PGS133502 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 1, 1, 2, 3, 1, 2, 3, 1}));
    }

    public static int solution(int[] ingredient) {
        int answer = 0;

        StringBuilder sb = new StringBuilder(Arrays.toString(ingredient));
        sb.delete(0, 1);
        sb.delete(sb.length() - 1, sb.length());
        sb.append(", ");

        int index = -1;
        while (true) {
            index = sb.indexOf("1, 2, 3, 1, ");

            if (index == -1) {
                break;
            }

            sb.delete(index, index + 12);
            answer++;
        }
        return answer;
    }
}
