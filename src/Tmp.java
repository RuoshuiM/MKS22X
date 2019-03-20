import java.util.Arrays;

public class Tmp {
  static void insertionsort(int[] arr, int low, int high) {
    // i is the current number to be inserted, high is inclusive
    for (int i = low + 1; i <= high; i++) {
      int cur = arr[i];
      // loop through all the sorted elements
      for (int j = i - 1; j >= low; j--) {
        // if current number is greater than the sorted value, then cur is in sorted position
        // System.out.format("cur: %d, future: %d%ncurIndex: %d, futureIndex:%d%n", cur, arr[j], i, j);
        if (cur >= arr[j]) {
          break;
        } else {
          aswap(arr, j + 1, j);
          // System.out.format("Switched, first: %d, second: %d%n", arr[i], arr[j]);
        }
        // System.out.format("Switched: %s%n", Arrays.toString(arr));
      }
    }
  }

  private static void aswap(int[] arr, int a, int b) {
      int tmp = arr[a];
      arr[a] = arr[b];
      arr[b] = tmp;
  }

  public static void main(String... args) {
    for (int i = 0; i < 6; i++) {
      int[] arr = {9, 8, 7, 3, 0, 7};
      insertionsort(arr, 2, i);
      System.out.println(Arrays.toString(arr));
    }

    // compareSorts();
  }

  public static void compareSorts() {
      System.out.println("Size\t\tMax Value\tmerge/builtin(dual-pivot) ratio ");
      int[] MAX_LIST = { 1000000000, 500, 10 };
      for (int MAX : MAX_LIST) {
          for (int size = 2; size < 50; size *= 2) {
              long qtime = 0;
              long btime = 0;
              // average of 5 sorts.
              for (int trial = 0; trial <= 5; trial++) {
                  int[] data1 = new int[size];
                  int[] data2 = new int[size];
                  for (int i = 0; i < data1.length; i++) {
                      data1[i] = (int) (Math.random() * MAX);
                      data2[i] = data1[i];
                  }
                  long t1, t2;
                  t1 = System.currentTimeMillis();
                  insertionsort(data2, 0, data2.length - 1);
                  t2 = System.currentTimeMillis();
                  qtime += t2 - t1;
                  t1 = System.currentTimeMillis();
                  Arrays.sort(data1);
                  t2 = System.currentTimeMillis();
                  btime += t2 - t1;

                  System.out.format("builtin: %d, mytime: %d%n", btime, qtime);
                  if (!Arrays.equals(data1, data2)) {
                      System.out.println("FAIL TO SORT!");
                      System.exit(0);
                  }
              }
//                System.out.format("qtime: %d%nbtime: %d%n", qtime, btime);
              System.out.println(size + "\t\t" + MAX + "\t" + 1.0 * qtime / btime);
          }
          System.out.println();
      }
  }
}
