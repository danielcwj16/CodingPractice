/**
 * http://www.cnblogs.com/springfor/p/3884252.html
 * 一步步填数，不满足就回溯，直到填满为止。类似N皇后问题。对一个格子，如果‘1’到‘9’都不满足，则返回false，sudoku无解
 */
public class Sudoku {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0)
            return;
        helper(board);
    }

    public boolean helper(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                if (board[i][j] == '.') {
                    for (char num = '1'; num < '9'; num++) {

                        if (isValid(i, j, board, num)) {
                            board[i][j] = num;
                            if (helper(board))
                                return true;
                            else
                                board[i][j] = '.';
                        }
                    }
                    return false;
                }

            }
        }

        return true;
    }

    public boolean isValid(int i, int j, char[][] board, char c) {
        //check column
        for (int row = 0; row < 9; row++) {
            if (board[row][j] == c)
                return false;
        }

        //check row
        for (int col = 0; col < 9; col++) {
            if (board[i][col] == c)
                return false;
        }

        //check block
        for (int row = i / 3 * 3; row < i / 3 * 3 + 3; row++) {
            for (int col = j / 3 * 3; col < j / 3 * 3 + 3; col++) {
                if (board[row][col] == c)
                    return false;
            }
        }

        return true;
    }
}