/**
 *
 */
package radix;

import java.util.Arrays;

/**
 * @author ruosh
 *
 */
public class Radix {

    /**
     * Radix sort should get faster when the arraySize : maxValue ratio increases.
     * (More elements and smaller max value)
     *
     * This sort modifies the array
     *
     * Negative values can be done as per the discussion in class
     *
     * @param data array to be sorted
     */
    public static void radixsort(int[] data) {
        // two buckets for each value of a bit: 0, 1
        MyLinkedList<Integer> b0 = new MyLinkedList<>(), b1 = new MyLinkedList<>(), sorted = new MyLinkedList<>();

        for (int j = 0; j < data.length; j++) {
            if ((data[j] & 1) == 1) {
                b1.push(data[j]);
            } else {
                b0.push(data[j]);
            }
        }

        b0.extend(b1);
        sorted.from(b0);
        b0.minimalClear();

        System.out.format("first pass%n");

        for (int i = 1; i < Integer.SIZE; i++) {
            int j = 0;
            for (int e : sorted) {
                if ((e >>> j++ & 1) == 1) {
                    b1.push(e);
                } else {
                    b0.push(e);
                }
            }

            if (i != Integer.SIZE - 1) {
                b0.extend(b1);
                sorted.from(b0);
                b0.minimalClear();
            } else {
                // we are on the sign bit. negative are in b1 while positive in b0
                b1.extend(b0);
                sorted.from(b1);
            }

            System.out.println(i + " pass");
        }

        int i = 0;
        for (Object e : sorted.<Integer>toArray()) {
            data[i++] = (Integer)e;
        }

    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] data = new int[] {4, 5, -1, 54, 5, 134};
        System.out.println(Arrays.toString(data));

        radixsort(data);
        System.out.println(Arrays.toString(data));
    }

}
