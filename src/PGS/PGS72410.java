package PGS;

public class PGS72410 {

    public static void main(String[] args) {

        System.out.println(solution("...!@BaT#*..y.abcdefghijklm"));
        System.out.println(solution("z-+.^."));
        System.out.println(solution("=.="));
        System.out.println(solution("123_.def"));
        System.out.println(solution("abcdefghijklmn.p"));
    }

    public static String solution(String new_id) {

        new_id = new_id.toLowerCase()
            .replaceAll("[^a-z0-9-_\\.]", "")
            .replaceAll("[\\.]+", ".")
            .replaceAll("^\\.|\\.$", "");

        if (new_id.length() == 0) {
            new_id = "a";
        }

        if (new_id.length() > 15) {
            new_id = new_id.substring(0, 15);
        }

        new_id = new_id.replaceAll("\\.$", "");

        while (new_id.length() < 3) {
            new_id += new_id.substring(new_id.length() - 1, new_id.length());
        }

        return new_id;
    }
}
