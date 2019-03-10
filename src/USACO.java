import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.BufferedReader;

public class USACO {
  public static int bronze(String filename) {

    try (BufferedReader inFile = new BufferedReader(new FileReader(filename))) {
      String[] specs = inFile.readLine().split(" ");
      final int ROW = Integer.parseInt(specs[0]);
      final int COL = Integer.parseInt(specs[1]);
      final int LAKE_ELEVATION = Integer.parseInt(specs[2]);
      final int NUM_INSTRUCTIONS = Integer.parseInt(specs[3]);
      int[][] pasture = new int[ROW][COL];

      for (int r = 0; r < ROW; r++) {
        String[] cells = inFile.readLine().split(" ");
        for (int c = 0; c < COL; c++) {
          pasture[r][c] = Integer.parseInt(cells[c]);
        }
      }
      // pasture is made
      printArrays(pasture);


      // stomping pasture
      for (int i = 0; i < NUM_INSTRUCTIONS; i++) {
        String[] cells = inFile.readLine().split(" ");
        int srow = Integer.parseInt(cells[0]) - 1;
        int scol = Integer.parseInt(cells[1]) - 1;
        int sdepth = Integer.parseInt(cells[2]);

        int maxDepth = 0;

        for (int j = 0; j < 3; j++) {
          for (int k = 0; k < 3; k++) {
            int depth = pasture[srow + j][scol + k];
            maxDepth = Math.max(maxDepth, depth);
          }
        }

        int newDepth = maxDepth - sdepth;

        for (int j = 0; j < 3; j++) {
          for (int k = 0; k < 3; k++) {
            pasture[srow + j][scol + k] = Math.min(newDepth, pasture[srow + j][scol + k]);
          }
        }

        printArrays(pasture);
      }

      int totalDepth = 0;

      for (int[] row : pasture) {
        for (int depth : row) {
          totalDepth += Math.max(LAKE_ELEVATION - depth, 0);
        }
      }

      return totalDepth;

    } catch (FileNotFoundException e) {
      return -1;
    } catch (IOException e) {
      return -1;
    }
  }

  public static int silver(String filename) {
    return -1;
  }

  public static void printArrays(int[][] nums) {
    for (int[] row : nums) {
      for (int cell : row) {
        System.out.print(cell + " ");
      }
      System.out.println();
    }
  }

  public static void main(String...args) {
    System.out.println(bronze("makelake.in"));
  }
}
