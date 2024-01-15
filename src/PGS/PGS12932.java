package PGS;

public class PGS12932 {

    public static void main(String[] args) {
        System.out.println(solution(12345));
    }

    public static int[] solution(long n) {

        StringBuilder sb = new StringBuilder(Long.toString(n));
        sb.reverse();
        String[] a = sb.toString().split("");

        int[] answer = new int[a.length];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = Integer.parseInt(a[i]);
        }

        return answer;
    }

}
