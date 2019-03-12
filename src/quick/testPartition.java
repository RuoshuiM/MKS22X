package quick;

import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.Test;

public class testPartition {

    @Test(expected = AssertionError.class)
    public void testAssertionEnabled() {
        assert false;
    }

    @Test
    public void testFewNums() {
        final int size = 10;
        int start = 0;
        int end = size - 1;

        for (int i = 0; i < 3; i++) {
            int[] arr = generateIntArray(size, 0, 10000);
            int pivotIndex = Quick.partition(arr, start, end);
            testArrayPivoted(arr, pivotIndex, start, end);
        }
    }

    @Test
    public void testLotsOfNums() {
        final int size = 1000;
        int start = 0;
        int end = size - 1;

        for (int i = 0; i < 2; i++) {
            int[] arr = generateIntArray(size, 0, 10000);
            int pivotIndex = Quick.partition(arr, start, end);
            testArrayPivoted(arr, pivotIndex, start, end);
        }
    }

    @Test
    public void testSpecificSizes() {
        final int[] sizes = new int[] { 2, 2 * 2, 2 * 2 * 2, 2 * 2 * 2 * 2 * 2 * 2,
                2 * 2 * 2 * 2 * 2 * 2 * 2 * 2 * 2 * 2, 3 * 3 * 3 };
        // Test case of size 1 doesn't work

        for (int size : sizes) {
            int start = 0;
            int end = size - 1;

            int[] arr = generateIntArray(size, 0, 10000);
            int pivotIndex = Quick.partition(arr, start, end);
            testArrayPivoted(arr, pivotIndex, start, end);
        }
    }

    @Test
    public void testLargeValueSpace() {
        final int size = 50;
        int start = 0;
        int end = size - 1;

        for (int i = 0; i < 2; i++) {
            int[] arr = generateIntArray(size, 0);
            int pivotIndex = Quick.partition(arr, start, end);
            testArrayPivoted(arr, pivotIndex, start, end);
        }
    }

    @Test
    public void testSmallValueSpace() {
        final int size = 10;
        int start = 0;
        int end = size - 1;

        for (int i = 0; i < 3; i++) {
            int[] arr = generateIntArray(size, 1, 20);
            int pivotIndex = Quick.partition(arr, start, end);
            testArrayPivoted(arr, pivotIndex, start, end);
        }
    }

    private void testArrayPivoted(int[] arr, int pivotIndex, int start, int end) {
        int pivot = arr[pivotIndex];
        for (int i = start; i < pivotIndex; i++) {
            assertTrue("Vals on the left of pivot should be < pivot", arr[i] <= pivot);
        }

        for (int i = pivotIndex; i <= end; i++) {
            assertTrue("Vals on the right of pivot should be > pivot", arr[i] >= pivot);
        }
//        System.out.println(Arrays.toString(arr));
//        System.out.println("Pivot: " + pivot);
    }

    private int[] generateIntArray(int size, int min, int max) {
        Random rand = new Random();
        int[] a = new int[size];
        int range = max + 1 - min;
        for (int i = 0; i < size; i++) {
            a[i] = rand.nextInt(range) + min;
        }

        return a;
    }

    private int[] generateIntArray(int size, int min) {
        Random rand = new Random();
        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = rand.nextInt() + min;
        }

        return a;
    }
}
