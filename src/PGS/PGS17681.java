package PGS;

public class PGS17681 {
    public static void main(String[] args) {

    }

    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < arr1.length; i++) {
            sb = new StringBuilder();
            String a = toBinary(n, arr1[i] | arr2[i]);

            for (int j = 0; j < a.length(); j++) {
                if (a.charAt(j) == '1') {
                    sb.append("#");
                } else {
                    sb.append(" ");
                }
            }

            answer[i] = sb.toString();
        }

        return answer;
    }

    public String toBinary(int size, int n) {
        String s = Integer.toBinaryString(n);

        return "0".repeat(size - s.length()) + s;
    }
}
