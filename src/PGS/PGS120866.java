package PGS;

import java.util.Arrays;

/**
 * 120866. 안전지대
 */

public class PGS120866 {

    public static void main(String[] args) {
//        solution(new int[][]{{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}});
        solution(new int[][]{{1, 0, 1, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}});
    }

    public static int solution(int[][] board) {
        int answer = 0;

        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                if (board[i][j] != 1) {
                    continue;
                }
                //0 1
                //01
                for (int ii = Math.max(i - 1, 0); ii<=(Math.min(i + 1, board.length-1)); ii++) {
                    for (int jj = Math.max(j-1, 0); jj<=(Math.min(j + 1, board[0].length-1)); jj++) {
                        if (board[ii][jj] != 1) {
                            board[ii][jj] = 2;
                        }
                    }
                }
            }
        }

        for (int[] ints : board) {
            for (int j = 0; j < board[0].length; j++) {
                if (ints[j] == 0) {
                    answer++;
                }
            }
        }

        return answer;
    }

    public static int solution2(int[][] board) {
        int answer = 0;

        for (int i=0; i<board.length; i++) {
            loopJ:
            for (int j=0; j<board[0].length; j++) {
                if (board[i][j] != 0) {
                    continue;
                }

                int[] boom = new int[8];
                if (i>0 && j>0) {
                    boom[0] = board[i-1][j-1];
                    boom[1] = board[i-1][j];
                }
                if (i>0 && j<board[0].length-1) {
                    boom[2] = board[i-1][j+1];
                    boom[3] = board[i][j+1];
                }
                if (i<board.length-1 && j>0) {
                    boom[4] = board[i][j-1];
                    boom[5] = board[i+1][j-1];
                    boom[6] = board[i+1][j];
                }
                if (i<board.length-1 && j<board[0].length-1) {
                    boom[7] = board[i+1][j+1];
                }

                for (int k=0; k<boom.length; k++) {
                    if (boom[k] == 1) {
                        board[i][j] = -1;
                        continue loopJ;
                    }
                }

                answer++;

            }
        }

        return answer;
    }
}
