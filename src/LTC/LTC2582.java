package LTC;

/**
 * 2582. Pass the Pillow
 */

public class LTC2582 {

    public int passThePillow(int n, int time) {
        int a = time / (n - 1);
        int b = time % (n - 1);

        return a % 2 == 0 ? 1 + b : n - b;
    }
}
