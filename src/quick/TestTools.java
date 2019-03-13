package quick;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Random;

public class TestTools {
    static int[] generateIntArray(int size, int min, int max) {
        Random rand = new Random();
        int[] a = new int[size];
        int range = max + 1 - min;
        for (int i = 0; i < size; i++) {
            a[i] = rand.nextInt(range) + min;
        }

        return a;
    }

    static int[] generateIntArray(int size, int min) {
        Random rand = new Random();
        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = rand.nextInt() + min;
        }

        return a;
    }
    
    static void testIntArraysEquals(int[] sorted, int[] arr) {
        System.out.println("Sys sort: " + Arrays.toString(sorted));
        System.out.println("My sort:  " + Arrays.toString(arr));

        assertTrue("Expected sorted array", Arrays.equals(arr, sorted));
    }
}
