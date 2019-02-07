/**
 * 
 */
package recursion;

/**
 * @author ruosh
 *
 */
public class NQueens {
    public static boolean isPlaceable(int n) {
        int[][] board = new int[n][n];
        
        
    }
    
    private static boolean isColPlaceable(int[][] board, int col) {
        if (col == board.length) {
            return true;
        }
        
        for (int row = 0; row < board.length; row++) {
            if (board[row][col] == 0) {
                board[row][col] = -1;
                // set invalid areas
                for (int i = row; i < board.length; i++) {
                    for (int j = col; j < board.length; j++) {
                        if (i == row || j == col || i - j == row - col) {
                            board[i][j]++;
                        }
                    }
                }
                
                if (!isColPlaceable(board, col + 1)) {
                    // clean up
                    for (int i = row; i < board.length; i++) {
                        for (int j = col; j < board.length; j++) {
                            if (i == row || j == col || i - j == row - col) {
                                board[i][j]--;
                            }
                        }
                    }
                    board[row][col] = 0;
                    return false;
                } else {
                    return true;
                }
            }
        }
    }
}
