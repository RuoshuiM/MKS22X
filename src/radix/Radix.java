/**
 * 
 */
package radix;

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

        for (int i = 1; i < Integer.SIZE; i++) {
            int j = 0;
            for (int e : sorted) {
                if ((e >> j++ & 1) == 1) {
                    b1.push(e);
                } else {
                    b0.push(e);
                }
            }
            
            b0.extend(b1);
            sorted.from(b0);
        }
        
        
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
