package quick;

import java.util.Arrays;
import java.util.Random;

public class Quick {

    /**
     * @return the value that is the kth smallest value of the array.
     */
    public static int quickselect(int[] data, int k) {
        int start = 0;
        int end = data.length - 1;

        int pivotIndex = -1;
        while (pivotIndex != k) {
            pivotIndex = partition(data, start, end);
            if (pivotIndex > k) {
                end = pivotIndex;
            } else if (pivotIndex < k) {
                start = pivotIndex;
            }
        }

        return data[pivotIndex];
    }

    /**
     * Modify the array such that: <br>
     * 1. Only the indices from start to end inclusive are considered in range <br>
     * 2. A random index from start to end inclusive is chosen, the corresponding
     * element is designated the pivot element. <br>
     * 3. all elements in range that are smaller than the pivot element are placed
     * before the pivot element. <br>
     * 4. all elements in range that are larger than the pivot element are placed
     * after the pivot element.
     *
     * @return the index of the final position of the pivot element.
     */
    static int partition(int[] data, int start, int end) {
        Random rand = new Random();
        int pivotIndex = rand.nextInt(end + 1 - start) + start;
        int pivot = data[pivotIndex];

        // swap pivot with first element
        aswap(data, start, pivotIndex);
        pivotIndex = start;
        start++;

        // now swap elements according to pivot
        while (start < end) {
            if (data[start] < pivot)
                start++;
            else if (data[end] > pivot)
                end--;
            else {
                aswap(data, start, end);
            }
        }

        assert start == end;
        aswap(data, pivotIndex, (data[start] < pivot ? start : start - 1));

        // if pivot is not at index "start", then it is at "start - 1"
        return pivot == data[start] ? start : start - 1;
    }

    private static void aswap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    private static int[] partitionDutch(int[] data,int start, int end){
      Random rand = new Random();
      int pivotIndex = rand.nextInt(end + 1 - start) + start;
      int pivot = data[pivotIndex];

      for (int i = start + 1; i <= end; i++) {
        int cur = data[i];
        if (cur > pivot) {
              aswap(data, i, end);
              end--;
        } else if (cur < pivot) {
            aswap(data, i, start);
            start++;
        } else {
            aswap(data, i, start);
        }
      }

    return new int[] {start, end};
  }

    /**
     * Modify the array to be in increasing order.
     */
     public static void quicksort(int[] data) {

     }


    public static void main(String[] args) {
      int[] arr = {0, 2, 3, 2, 1, 2, 2, 4, 5, 7};
      System.out.println("Arr: "+Arrays.toString(arr));
      int[] result = partitionDutch(arr, 0, arr.length-1);
      System.out.println("Partitioned: " + Arrays.toString(arr));
      System.out.println("Re: " + Arrays.toString(result));
        // for (int i = 0; i < 6; i++) {
        //     int[] ary = { 2, 10, 15, 23, 0, 5 };
        //     System.out.println(quickselect(ary, i));
        // }
    }

}
