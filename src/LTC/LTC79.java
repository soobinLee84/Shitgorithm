package LTC;

public class LTC79 {


    public boolean exist(char[][] board, String word) {

        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                if (board[r][c] == word.charAt(0)) {
                    if (search(board, word, visited, r, c, 0)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean search(char[][] board, String word, boolean[][] visited,  int row, int col, int index) {

        if (index == word.length()) {
            return true;
        }

        if (row < 0 || row >= board.length
                || col < 0 || col >= board[0].length
                || visited[row][col]
                || board[row][col] != word.charAt(index)) {
            return false;
        }

        visited[row][col] = true;

         if(search(board, word, visited, row + 1, col, index + 1)
                || search(board, word, visited, row - 1, col, index + 1)
                || search(board, word, visited, row, col + 1, index + 1)
                || search(board, word, visited, row, col - 1, index + 1)) {
             return true;
         }

         visited[row][col] = false;
         return false;
    }
}
