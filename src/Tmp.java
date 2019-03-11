import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Tmp {

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
            if (data[start] < pivot) start++;
            else if (data[end] > pivot) end--;
            else {
                aswap(data, start, end);
            }
        }
        
        assert start == end;
        aswap(data, pivotIndex, (data[start] < pivot ? start: start - 1));
        
        // if pivot is not at index "start", then it is at "start - 1"
        return pivot == data[start] ? start : start - 1;
    }

    private static void aswap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static void main(String[] args) {
        int[] array = new int[] {17, 61, 67, 47, 93,12, 20, 4, 44, 68};
        System.out.println(Arrays.toString(array));
        
        int index = partition(array, 2, array.length - 1);
        
        System.out.println(index);
        System.out.println(Arrays.toString(array));
    }
    
    
}
