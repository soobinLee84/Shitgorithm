package PGS;

public class PGS81301 {

    public static void main(String[] args) {
        System.out.println(solution("one4seveneight"));  //1478
        System.out.println(solution("23four5six7"));  //234567
        System.out.println(solution("2three45sixseven"));  //234567
    }

    public static int solution(String s) {
        s = s.replaceAll("zero", "0");
        s = s.replaceAll("one", "1");
        s = s.replaceAll("two", "2");
        s = s.replaceAll("three", "3");
        s = s.replaceAll("four", "4");
        s = s.replaceAll("five", "5");
        s = s.replaceAll("six", "6");
        s = s.replaceAll("seven", "7");
        s = s.replaceAll("eight", "8");
        s = s.replaceAll("nine", "9");

        return Integer.parseInt(s);
    }
}
