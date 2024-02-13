package PGS;

public class PGS55073 {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"ayaayaa", "ye"}));
    }

    public static int solution(String[] babbling) {
        int answer = 0;

        String s = String.join(",", babbling);

        s = s.replaceAll("ayaaya|yeye|woowoo|mama", "k");
        s = s.replaceAll("aya|ye|woo|ma", "");

        String[] a = s.split(",", -1);
        for (int i = 0; i < a.length; i++) {
            if ("".equals(a[i])) {
                answer++;
            }
        }

        return answer;
    }
}
