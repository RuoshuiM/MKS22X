package recursion;

import java.util.*;
import java.io.*;

public class Maze{

    // private static class Positions {
    //   private int row;
    //   private int col;
    //
    //   public Positions(int row, int col) {
    //     this.row = row;
    //     this.col = col;
    //   }
    //
    //   public int up() {
    //     return new int[] {row - 1, col};
    //   }
    //
    //   public int down() {
    //     return new int[] {row + 1, col};
    //   }
    //
    //   // finish??
    // }

    private static int[][] positions = new int[][] {
      // up
      {-1, 0},
      // down
      {1, 0},
      // right
      {0, 1},
      // left
      {0, -1}
    }

    private char[][] maze;
    private boolean animate;//false by default

    /*Constructor loads a maze text file, and sets animate to false by default.

      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - Walls - locations that cannot be moved onto
      ' ' - Empty Space - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)

      'S' - the location of the start(exactly 1 per file)

      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!


      3. When the file is not found OR the file is invalid (not exactly 1 E and 1 S) then:

         throw a FileNotFoundException or IllegalStateException

    */

    public Maze(String filename) throws FileNotFoundException{
        //COMPLETE CONSTRUCTOR
        try (BufferedReader file = new BufferedReader(new FileReader(filepath));){

          String line = file.readLine();
          StringBuilder lines = new StringBuilder();
          final String lnBk = System.lineSeparator();

          while (line != null) {
            System.out.println(line);
            lines.append(lnBk);
            lines.append(line);
            line = file.readLine();
          }

          String lineStr = lines.toString();
          String[] rows = lineStr.split(lnBk);

          String[][] charArray = new String[rows.length][rows[0].length()];
          for (int i = 0; i < rows.length; i++) {
              charArray[i] = rows[i].split("");
          }

        } catch (FileNotFoundException e) {
          System.err.println("File not found");
        } catch (IOException e) {
          System.err.println("Error reading file");
        }

        this.setAnimate = false;
    }


    private void wait(int millis){
         try {
             Thread.sleep(millis);
         }
         catch (InterruptedException e) {
         }
     }


    public void setAnimate(boolean b){

        animate = b;

    }


    public void clearTerminal(){

        //erase terminal, go to top left of screen.

        System.out.println("\033[2J\033[1;1H");

    }



    /*Wrapper Solve Function returns the helper function

      Note the helper function has the same name, but different parameters.
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.

    */
    public int solve(){

            //find the location of the S.


            //erase the S


            //and start solving at the location of the s.

            //return solve(???,???);

    }

    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.

      Returns the number of @ symbols from S to E when the maze is solved,
      Returns -1 when the maze has no solution.


      Postcondition:

        The S is replaced with '@' but the 'E' is not.

        All visited spots that were not part of the solution are changed to '.'

        All visited spots that are part of the solution are changed to '@'
    */
    private int solve(int row, int col, int level){ //you can add more parameters since this is private


        //automatic animation! You are welcome.
        if (animate) {

            clearTerminal();
            System.out.println(this);

            wait(20);
        }

        //COMPLETE SOLVE
        if (maze[row][col] == " ") {
          // try all directions
          maze[row][col] = "@";

          int up = solve(row - 1, col, level + 1);
          if (up != -1) return up;
          int down = solve(row + 1, col, level + 1);
          if (down != -1) return down;
          int right = solve(row, col + 1, level + 1);
          if (right != -1) return right;

          for (int[] pos : positions) {
            int result = solve(row + pos[0], col + pos[1], level + 1);
            if (result != -1) return result;
          }

          maze[rol][col] = ".";
          return -1;

        } else if (maze[row][col] == "E") {
          return level;
        } else {
          return -1;
        }
    }

    @Override
    public String toString() {
      for (String[] row : charArray) {
          for (String c : row) {
              System.out.print(c);
          }
          System.out.format("%n");
      }
    }


}
