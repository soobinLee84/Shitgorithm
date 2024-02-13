package PGS;

public class PGS136798 {

    public static void main(String[] args) {
        System.out.println(solution(5, 3, 2));
    }

    public static int solution(int number, int limit, int power) {
        int answer = 0;
        int[] member = new int[number];

        for (int i = 0; i < member.length; i++) {
            member[i] = count(i + 1);
            answer += member[i] > limit ? power : member[i];
        }

        return answer;
    }

    public static int solution2(int number, int limit, int power) {
        int answer = 0;
        int[] member = new int[number];

        for (int i = 1; i <= number; i++) {
            for (int j = 1; j <= number / i; j++) {
                member[i * j]++;
            }
        }

        for (int m : member) {
            answer += m > limit ? power : m;
        }

        return answer;
    }


    public static int count(int n) {
        if (n == 1) return 1;

        int count = 2;
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (n % i == 0) {
                count += 2;
            }
        }

        if (Math.sqrt(n) % 1 == 0)
            count += 1;

        return count;
    }
}
