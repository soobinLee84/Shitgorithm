package PGS;

public class PGS134240 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 3, 4, 6}));
    }

    public static String solution(int[] food) {

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < food.length; i++) {
            for (int j = 0; j < food[i] / 2; j++) {
                sb.append(i);
            }
        }

        return sb + "0" + sb.reverse();
    }
}
