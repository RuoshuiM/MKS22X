package recursion;

import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;

public class ReadFile {
  public static void main(String... args) {
    printFile("Maze1.txt");
    
  }

  public static void printFile(String name) {
      File maze = new File("./Maze2.txt");
      String filepath = System.getProperty("user.dir").concat("\\src\\recursion\\"+name);
      System.out.println(filepath);
      System.out.println();
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
      
      for (String[] row : charArray) {
          for (String c : row) {
              System.out.print(c);
          }
          System.out.format("%n");
      }
      
    } catch (FileNotFoundException e) {
      System.err.println("File not found");
    } catch (IOException e) {
      System.err.println("Error reading file");
    }
  }
}
