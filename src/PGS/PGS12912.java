package PGS;

public class PGS12912 {

    public static void main(String[] args) {
        System.out.println(solution(3, 5));
    }

    public static long solution(int a, int b) {

        return sumAtoB(Math.min(a, b), Math.max(a, b));
    }

    public static long sumAtoB(long i, long j) {
        i = i - 1;
        return (j * (j + 1) / 2) - (i * (i + 1) / 2);
    }
}
