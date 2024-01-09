package PGS;

public class PGS82612 {

    public static void main(String[] args) {

        System.out.println(solution(3, 20, 4));
        System.out.println(solution(3, 20, 2));
    }

    public static long solution(int price, int money, int count) {
        long answer = 0;
        for (int i = 1; i < count + 1; i++) {
            answer += (price * i);
        }

        return (money < answer) ? answer - money : 0;
    }

}
