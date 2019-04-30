package heap;

import java.util.ArrayList;
import java.util.Arrays;

public class MyHeap {
    /**
     * - size is the number of elements in the data array. <br>
     * - push the element at index i downward into the correct position. This will
     * swap with the larger of the child nodes provided that child is larger. This
     * stops when a leaf is reached, or neither child is larger. [ should be O(logn)
     * ] <br>
     * - precondition: index is between 0 and size-1 inclusive <br>
     * - precondition: size is between 0 and data.length-1 inclusive.
     *
     * @param data
     * @param size
     * @param index
     */
    private static void pushDown(int[] data, int size, int index) {
        while (index < size) {
            int firstIndex = data[indexFirstChild(index)];
            int secondIndex = data[indexSecondChild(index)];

            if (firstIndex > size) {
                // first index out of bound, then second index must also be out of bound, so
                // stop
                break;
            }

            // store current value for reference
            int cur = data[index];

            if (secondIndex > size) {
                // only compare first
                int fc = data[firstIndex];
                if (cur >= fc)
                    break;
                else {
                    aswap(data, index, fc);
                    // since second index is out, then we know that this must be the bottom of the
                    // heap, no need to continue
                    break;
                }
            }

            int fc = data[firstIndex];
            int sc = data[secondIndex];

            if (cur >= fc && cur >= sc) {
                break;
            } else if (fc > sc) {
                // first child is larger than second child
                aswap(data, index, fc);
                index = firstIndex;
            } else {
                // second child is larger than first child
                aswap(data, index, sc);
                index = secondIndex;
            }
        }
    }

    /**
     * - push the element at index i up into the correct position. This will swap it
     * with the parent node until the parent node is larger or the root is reached.
     * [ should be O(logn) ] <br>
     * - precondition: index is between 0 and data.length-1 inclusive.
     *
     * @param data
     * @param index
     */
    private static void pushUp(int[] data, int index) {
        while (index > 0) {
            int parentIndex = indexParent(index);
            if (data[parentIndex] < data[index]) {
                aswap(data, index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    /**
     * convert the array into a valid heap. [ should be O(n) ]
     *
     * @param data
     */
    public static void heapify(int[] data) {
        int start = indexParent(data.length - 1);
        for (int i = start; i >= 0; i--) {
            pushDown(data, data.length - 1, i);
        }
    }

    /**
     * Sort the array by converting it into a heap then removing the largest value
     * n-1 times. [ should be O(nlogn) ]
     *
     * @param data
     */
    public static void heapsort(int[] data) {
        heapify(data);
        int end = data.length - 1;
        while (end > 0) {
            aswap(data, 0, end);
            pushDown(data, end, 0);
            end--;
        }
    }

    private static void aswap(int[] d, int ai, int bi) {
        int tmp = d[ai];
        d[ai] = d[bi];
        d[bi] = tmp;
    }

    private static int indexParent(int i) {
        return (i - 1) / 2;
    }

    private static int indexFirstChild(int i) {
        return i * 2 + 1;
    }

    private static int indexSecondChild(int i) {
        return i * 2 + 2;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 5, 6, 7, 8, 8, 5, 54, 100};
        int[] carr = Arrays.copyOf(arr, arr.length);
        heapify(carr);
        System.out.println("This should be a heap: " + Arrays.toString(carr));
        System.out.println(toString(carr));
        System.out.println("Sorting");
        heapsort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(toString(arr));
    }

    public static String toString(int[] array) {

    if (array.length == 0) return "";
    int largest = array[0];
    for (int j = 1; j < array.length; j++)
        if (Math.abs(largest) < Math.abs(array[j])) largest = array[j];

    int size = 1;
    while (size <= array.length) size <<= 1;
    int buffer = (size>>1)*(int)(Math.log(Math.abs(largest))/Math.log(10)+(largest > 0 ? 1 : 2));

    StringBuilder sb = new StringBuilder();

    int i = 0;
    for (int row = 2; row <= size; row <<= 1) {

        for (; i < row-1 && i < array.length; i++) {
            int numlength = array[i] == 0 ? 1 : (int)(Math.log(Math.abs(array[i]))/Math.log(10))+(array[i] > 0 ? 1 : 2);
            for (int j = numlength; j < buffer; j++) {
                sb.append(" ");
            }
            sb.append(array[i]);
            for (int j = 0; j < buffer; j++) sb.append(" ");
        }
        if (row != size) sb.append("\n");
        buffer = buffer>>1;
    }

    return new String(sb);
}
}

class IntMaxHeap {
    private ArrayList<Integer> data;

    /**
     * Heaplify the array and make a new IntMaxHeap based on given array
     *
     * @param a array value which will comprise the new heap
     */
    public IntMaxHeap(int[] a) {

    }

    private int getParentIndex(int i) {
        return (i - 1) / 2;
    }

    private int getFChildIndex(int i) {
        return i * 2 + 1;
    }

    private int getSChildIndex(int i) {
        return i * 2 + 2;
    }

    private void pushDown(int i, int end) {

    }

    private void swap(int ai, int bi) {
        int tmp = data.get(ai);
        data.set(ai, data.get(bi));
        data.set(bi, tmp);
    }
}
