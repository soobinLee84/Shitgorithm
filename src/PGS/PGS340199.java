package PGS;

public class PGS340199 {

    public int solution(int[] wallet, int[] bill) {
        int answer = 0;

        while (min(wallet) < min(bill) || max(wallet) < max(bill)) {
            bill[bill[0] < bill[1] ? 1 : 0] /= 2;
            answer++;
        }

        return answer;
    }

    private int max(int[] arr) {
        return Math.max(arr[0], arr[1]);
    }

    private int min(int[] arr) {
        return Math.min(arr[0], arr[1]);
    }
}
