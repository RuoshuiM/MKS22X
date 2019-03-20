package quick;

import java.util.Random;

public class Quick {
    final int INSERSIONSORT_THRESHOLD = 45;

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

        if (end - start + 1 < INSERSIONSORT_THRESHOLD) {
          insertionsort(data, start, end);
        }

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

    private static void aswap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static int[] partitionDutch(int[] data, int start, int end) {
        Random rand = new Random();
        int pivotIndex = rand.nextInt(end + 1 - start) + start;
        int pivot = data[pivotIndex];

        // swap pivot with first element
        aswap(data, start, pivotIndex);
        pivotIndex = start;

        // use i to iterate through array
        // increment i only if cur == pivot or cur < pivot,
        // since the left side is always good; right side might have random vals

//        int i = start + 1;
//        while (i <= end) {
//            int cur = data[i];
//            if (cur > pivot) {
//                aswap(data, i, end);
//                end--;
//            } else if (cur < pivot) {
//                aswap(data, i, start);
//                start++;
//                i++;
//            } else {
//                i++;
//            }
//        }

        // equivalent to the while loop
        for (int i = start + 1; i <= end; i++) {
            int cur = data[i];
            if (cur > pivot) {
                aswap(data, i, end);
                end--;
                i--;
            } else if (cur < pivot) {
                aswap(data, i, start);
                start++;
            }
        }


        return new int[] { start, end };
    }

    /**
     * Modify the array to be in increasing order.
     */
    public static void quicksort(int[] data) {
        quicksort(data, 0, data.length - 1);
    }

    private static void quicksort(int[] data, int start, int end) {
        if (end - start < 1) return;

        int[] re = partitionDutch(data, start, end);
        int lt = re[0];
        int gt = re[1];
        quicksort(data, start, lt - 1);
        quicksort(data, gt + 1, end);
    }

}
