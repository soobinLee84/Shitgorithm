package LTC;

public class LTC134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int totalGas = 0, totalCost = 0;
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }

        if (totalGas < totalCost) {
            return -1;
        }

        int left = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {

            if (left + gas[i] - cost[i] < 0) {
                left = 0;
                start = i + 1;
            } else {
                left += gas[i] - cost[i];
            }
        }

        return start;
    }
}
