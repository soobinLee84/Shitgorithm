package PGS;

import java.util.ArrayList;
import java.util.List;

public class PGS64061 {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}},
                new int[]{1, 5, 3, 5, 1, 2, 1, 4}
        ));
    }

    public static int solution(int[][] board, int[] moves) {
        int answer = 0;

        List<Integer> list = new ArrayList<>();

        for (int i=0; i<moves.length; i++) {
            for (int j=0; j<board.length; j++) {
                if (board[j][moves[i]-1] > 0) {
                    list.add(board[j][moves[i]-1]);
                    board[j][moves[i]-1] = 0;
                    break;
                }
            }
        }

        int index = 0;
        while (index < list.size() - 1) {
            if(list.get(index) == list.get(index+1)) {
                answer += 2;
                list.remove(index);
                list.remove(index);

                index = index == 0? 0 : index-1;
            } else
                index++;
        }

        return answer;
    }
}
