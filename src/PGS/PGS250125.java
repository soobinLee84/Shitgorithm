package PGS;

public class PGS250125 {
    public static void main(String[] args) {

    }

    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        String target = board[h][w];

        if (h > 0 && target.equals(board[h - 1][w]))
            answer++;
        if (h < board.length - 1 && target.equals(board[h + 1][w]))
            answer++;
        if (w > 0 && target.equals(board[h][w - 1]))
            answer++;
        if (w < board[0].length - 1 && target.equals(board[h][w + 1]))
            answer++;

        return answer;
    }
}
