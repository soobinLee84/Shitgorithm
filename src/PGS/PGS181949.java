package PGS;

public class PGS181949 {

    public static void main(String[] args) {
        String a = "heLlO";

        StringBuilder result = new StringBuilder();
        for (char c : a.toCharArray()) {
            if (c - 'Z' <= 0) { //대문자
                result.append((char)(c + 32));
            } else { //소문자
                result.append((char)(c - 32));
            }
        }

        System.out.println(result);
    }
}
