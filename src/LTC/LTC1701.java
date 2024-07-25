package LTC;

/**
 * 1701. Average Waiting Time
 */

public class LTC1701 {

    public double averageWaitingTime(int[][] customers) {

        int time = customers[0][0];
        double result = 0;
        for (int i = 0; i < customers.length; i++) {
            if (time < customers[i][0]) {
                time = customers[i][0];
            }
            time += customers[i][1];
            result += (time - customers[i][0]);
        }

        return result / customers.length;

    }
}
