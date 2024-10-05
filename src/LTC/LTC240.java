package LTC;

import java.util.Arrays;

public class LTC240 {

    /**
     * 첫행의 마지막 열에서
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }

    public boolean searchMatrix2(int[][] matrix, int target) {

        for (int[] row : matrix) {
            if (Arrays.binarySearch(row, target) > -1)
                return true;
        }

        return false;
    }
}
