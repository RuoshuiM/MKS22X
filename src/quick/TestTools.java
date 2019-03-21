package quick;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Random;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.*;

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

    public static void compareSorts(/*String className, String sort*/) {
        System.out.println(MethodHandles.lookup().lookupClass());
//        try {
//
//            System.out.println("Size\t\tMax Value\tmerge/builtin(dual-pivot) ratio ");
//            int[] MAX_LIST = { 1000000000, 500, 10 };
//            for (int MAX : MAX_LIST) {
//                for (int size = 31250; size < 4000001; size *= 2) {
//                    long qtime = 0;
//                    long btime = 0;
//                    // average of 5 sorts.
//                    for (int trial = 0; trial <= 5; trial++) {
//                        int[] data1 = new int[size];
//                        int[] data2 = new int[size];
//                        for (int i = 0; i < data1.length; i++) {
//                            data1[i] = (int) (Math.random() * MAX);
//                            data2[i] = data1[i];
//                        }
//                        long t1, t2;
//
//                        Method mySort = Class.forName(className).getMethod(sort, int[].class);
//
//                        t1 = System.currentTimeMillis();
//                        mySort.invoke(null, data2);
//                        t2 = System.currentTimeMillis();
//
////                    t1 = System.currentTimeMillis();
//////                    mergesort(data2);
////                    t2 = System.currentTimeMillis();
//
//                        qtime += t2 - t1;
//
//                        t1 = System.currentTimeMillis();
//                        Arrays.sort(data1);
//                        t2 = System.currentTimeMillis();
//                        btime += t2 - t1;
//                        if (!Arrays.equals(data1, data2)) {
//                            System.out.println("FAIL TO SORT!");
//                            System.exit(0);
//                        }
//                    }
////                System.out.format("qtime: %d%nbtime: %d%n", qtime, btime);
//                    System.out.println(size + "\t\t" + MAX + "\t" + 1.0 * qtime / btime);
//                }
//                System.out.println();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    public static void main(String... args) {
        try {
            Class<?> cls = Class.forName("quick.Quick");
            Method mySort = cls.getMethod("quicksort", int[].class);
            int[] arr = { 1, 4, 5, 6, 10, 1 };
            mySort.invoke(null, arr);
            System.out.println(Arrays.toString(arr));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
