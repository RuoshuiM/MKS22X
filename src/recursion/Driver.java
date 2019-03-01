/**
 * 
 */
package recursion;

import java.io.FileNotFoundException;

/**
 *
 */
public class Driver {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String filename;
        if (args.length == 2) {
            filename = args[2];
        } else {
            filename = "Maze1.txt";
        }
        try {
            Maze f;
            f = new Maze(filename);// true animates the maze.

            f.setAnimate(true);
            
            f.solve();
            
            System.out.println(f);
            
        } catch (FileNotFoundException e) {
            System.err.println("Invalid filename: " + filename);
        }
    }

}
