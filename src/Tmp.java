import java.util.Arrays;

public class Tmp {
  /*sort the array from least to greatest value. This is a wrapper function*/
  public static void mergesort(int[]data) {
    int mid = data.length / 2;
    int[] low = Arrays.copyOfRange(data, 0, mid);
    int[] high = Arrays.copyOfRange(data, mid, data.length);

    mergesort(low);
    mergesort(high);

    data = merge(low, high);
  }

  private static int[] merge(int[] a, int[] b) {

    int[] result = new int[a.length + b.length];

    for (int ai = 0, bi = 0, i = 0; i < result.length; i++) {
      if (a[ai] < b[bi]) {
        result[i] = a[ai];
        ai++;
      } else {
        result[i] = b[bi];
        bi++;
      }
    }

    return result;
  }

  private static void mergesort(int[]data, int lo, int hi) {
    // if (!hi <= low) {
    //   int mi = (lo + hi) / 2;
    //
    //   mergesort(lo, mi);
    //   mergesort(mi + 1, hi);
    // }



  }

  private static void mergesort(int[]data, int[]temp, int lo, int hi) {

  }

  public static void main(String[]args){
    System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
    int[]MAX_LIST = {1000000000,500,10};
    for(int MAX : MAX_LIST){
      for(int size = 31250; size < 2000001; size*=2){
        long qtime=0;
        long btime=0;
        //average of 5 sorts.
        for(int trial = 0 ; trial <=5; trial++){
          int []data1 = new int[size];
          int []data2 = new int[size];
          for(int i = 0; i < data1.length; i++){
            data1[i] = (int)(Math.random()*MAX);
            data2[i] = data1[i];
          }
          long t1,t2;
          t1 = System.currentTimeMillis();
          Tmp.mergesort(data2);
          t2 = System.currentTimeMillis();
          qtime += t2 - t1;
          t1 = System.currentTimeMillis();
          Arrays.sort(data1);
          t2 = System.currentTimeMillis();
          btime+= t2 - t1;
          if(!Arrays.equals(data1,data2)){
            System.out.println("FAIL TO SORT!");
            System.exit(0);
          }
        }
        System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
      }
      System.out.println();
    }
  }
}
