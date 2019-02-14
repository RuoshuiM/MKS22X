/**
 *
 */
package recursion;

import java.util.Arrays;
import javafx.util.Pair;
import java.util.ArrayList;
import java.util.List;

/**
 * A knights tour:
 *
 * Selecting a series of moves for a knight such that each square is visited
 * exactly once. If the knight ends on a square that is reachable by a knight's
 * move from the beginning square, the tour is closed, otherwise it is open.
 *
 * <p>
 * Note:
 * <ul>
 * <li>The board dimensions do not have to be square.</li>
 * <li>The starting square counts as visited.</li>
 * <li>You do not have to come back to where you started. Closed tours take much
 * longer to find (potentially)</li>
 * </ul>
 * </p>
 *
 * <p>
 * Not all board sizes have solutions. A 2 by N board has no closed or open
 * tour. From Wikipedia: Any m �� n board with m �� n, a closed knight's tour is
 * always possible unless one or more of these three conditions are met:
 * <ol>
 * <li>m and n are both odd</li>
 * <li>m = 1, 2, or 4</li>
 * <li>m = 3 and n = 4, 6, or 8.</li>
 * </ol>
 * It follows that if a closed tour is possible, then an open tour is also
 * possible.
 * </p>
 */
public class KnightBoard {

    private int[][] board;
    private int rows;
    private int cols;
    private int maxLevel;

    /**
     * Initialize the board to the correct size and make them all 0's
     *
     * @throws IllegalArgumentException when either parameter is negative.
     */
    public KnightBoard(int startingRows, int startingCols) {
        if (startingRows <= 0 || startingCols <= 0) {
            throw new IllegalArgumentException("Size of the board must be positive");
        }

        this.board = new int[startingRows][startingCols];
        this.rows = startingRows;
        this.cols = startingCols;
        this.maxLevel = rows * cols - 1;
    }

    private void clearBoard() {
        board = new int[rows][cols];
    }

    private void checkBoard() {
        if (!Arrays.deepEquals(board, new int[rows][cols])) {
            throw new IllegalStateException("Board must be empty");
        }
    }

    private void checkInputs(int row, int col) {
        if (row < 0 || col < 0 || row > rows || col > cols) {
            throw new IllegalArgumentException("Board dimension must be nonnegative and in bounds");
        }
    }

    private boolean addKnight(int row, int col, int level) {
      if (row >= this.rows || col >= this.cols || row < 0 || col < 0) {
        return false;
      } else if (board[row][col] != 0) {
        return false;
      }
    }

    private boolean removeKnight(int row, int col) {
      if (board[row][col] == 0) {
        return false;
      } else {
        board[row][col] = 0;
        return true;
      }
    }

    /**
     * Solve the board.
     *
     * @throws IllegalStateException    when the board contains non-zero values.
     * @throws IllegalArgumentException when either parameter is negative or out of
     *                                  bounds.
     * @param startingRow
     * @param startingCol
     * @return false when the board is not solveable and leaves the board filled
     *         with zeros; true when the board is solveable, and leaves the board in
     *         a solved state
     */
    public boolean solve(int startingRow, int startingCol) {
        checkBoard();
        checkInputs(startingRow, startingCol);
        return nextMove(startingRow, startingCol, 0);
    }

    private boolean nextMove(int row, int col, int level) {
      if (level == maxLevel) return true;
      else {
        addKnight(row, col, level);
        int nextLevel = level + 1;
        int nextRow, nextCol;

        List<Pair<Integer,Integer>> cors = new ArrayList<>();

        // start trying each move
        cors.add(new Pair(row + 1, col + 2));
        cors.add(new Pair(row - 1, col + 2));
        cors.add(new Pair(row + 1, col - 2));
        cors.add(new Pair(row - 1, col - 2));
        cors.add(new Pair(row + 2, col + 1));
        cors.add(new Pair(row - 2, col + 1));
        cors.add(new Pair(row + 2, col - 1));
        cors.add(new Pair(row - 2, col - 1));

        for (Pair<Integer, Integer> cor : cors) {
          nextRow = cor.getKey();
          nextCol = cor.getValue();
          if (nextMove(nextRow, nextCol, nextLevel)) {
            return true;
          } else {
            removeKnight(nextRow, nextCol);
          }
        }
        return false;
      }
    }

    /**
     * Count the number of solutions.
     *
     * @throws IllegalStateException    when the board contains non-zero values.
     * @throws IllegalArgumentException when either parameter is negative or out of
     *                                  bounds.
     * @param startingRow
     * @param startingCol
     * @return The number of solutions found, and leaves the board filled with only
     *         0's
     */
    public int countSolutions(int startingRow, int startingCol) {
        checkBoard();
        checkInputs(startingRow, startingCol);
        throw new RuntimeException("Unimplemented");
    }

    private int subSolutions(int rol, int col, int level) {
        throw new RuntimeException("Unimplemented");
    }

    /**
     * (THESE ARE NOT VALID SOLUTIONS, They JUST TO DEMONSTRATE FORMAT)
     * <p>
     * Single spaces between numbers, but leading spaces on single digit numbers:
     *
     * <pre>
     1  2  5
     3  4  6
     7  8  9
     * </pre>
     *
     * Which is equivalant to: " 1 2 5\n 3 4 6\n 7 8 9\n"
     * </p>
     * <p>
     * When there are two digit numbers (rows*cols >= 10) Put a leading space in
     * front of single digit numbers: (spaces replaced with _ to show the
     * difference)
     *
     * <pre>
    _1 _2 15 _6
    _3 _4 _7 11
    _8 _9 10 12
    13 14 _5 16
     * </pre>
     *
     * So it looks like this:
     *
     * <pre>
     1  2 15  6
     3  4  7 11
     8  9 10 12
    13 14  5 16
     * </pre>
     * </p>
     * Blank boards display 0's as underscores.
     *
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        String format;

        if (rows * cols > 10 && board[0][0] != 0) {
            // need string padding
            int length = (int)Math.floor(Math.log10(rows * cols)) + 1;
            format = "%" + length + "d";
        } else {
            format = "%d";
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0 ; j < cols; j++) {
                s.append(String.format(format, board[i][j])).append(" ");
            }
            s.delete(s.length(), s.length()).append("\n");
        }

        return s.toString();
    }

    public static void main(String...args) {
      if (args.length != 0) {
        int rows = Integer.parseInt(args[0]);
        int cols = Integer.parseInt(args[1]);
        KnightBoard kb = new KnightBoard(rows, cols);
        System.out.println(kb);
        kb.solve(0, 0);
        System.out.println(kb);
      }
    }
}
