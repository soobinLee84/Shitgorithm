package PGS;

public class PGS140108 {
    public static void main(String[] args) {
        System.out.println(solution("abracadabra"));
    }

    public static int solution(String s) {
        int answer = 1;

        String[] ss = s.split("");

        int xIndex = 0;
        int xCount = 1;
        int yCount = 0;
        for (int i = 1; i < ss.length; i++) {
            if (ss[i].equals(ss[xIndex])) {
                xCount++;
            } else {
                yCount++;
            }

            if (xCount == yCount) {
                xIndex = ++i;
                xCount = 1;
                yCount = 0;

                if (xIndex == ss.length)
                    break;

                answer++;
            }
        }

        return answer;
    }
}
