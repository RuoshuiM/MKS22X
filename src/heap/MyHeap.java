package heap;

import java.util.ArrayList;

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
            
            
            int fc = firstIndex <= size? data[firstIndex] : Integer.MIN_VALUE;
            int sc = secondIndex <= size? data[secondIndex] : Integer.MIN_VALUE;
            int cur = data[index];
            

            if (cur > fc && cur > sc) {
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