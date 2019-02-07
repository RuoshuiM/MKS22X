package recursion;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class RecursionForClass {
    /**
     * @param n any non-negative value you want to take the sqrt of
     * @return the approximate sqrt of n within a tolerance of 0.001%
     */
    public static double sqrt(double n) {
        final double tolerance = 0.00001;
        return guess(n, tolerance, n / 2);
    }
    
    public static double sqrt(double n, double tolerance) {
        return guess(n, tolerance, n / 2);
    }
    
    private static double guess(double n, double tolerance, double guess) {
        if (n < 0 || guess < 0)
            throw new IllegalArgumentException("Radicant must be non-negative");
        if (Math.abs(guess * guess - n) <= n * tolerance) {
            return guess;
        } else {
            return guess(n, tolerance, (n / guess + guess) / 2);
        }
    }
    
    
    public static int fib(int n) {
        if (n < 0)
            throw new IllegalArgumentException("n must be non-negative");
        int f0 = 0;
        int f1 = 1;
        return (int) fib(n, 0, f0, f1);
    }
    
    /**
     * Recursively find the n'th fibbonaci number in linear time fib(0) = 0; fib(1)
     * = 1; fib(5) = 5; requires n >= 0.
     * 
     * @param n the number in the fibbonaci sequence
     *          <p>
     *          Largest safe value of n is 92. For any n > 92, method either return
     *          incorrect value because of int out of range or stack overflow.
     *          </p>
     * 
     * @return the n'th fibbonaci number
     */
    public static long longFib(int n) {
        if (n < 0)
            throw new IllegalArgumentException("n must be non-negative");
        int f0 = 0;
        int f1 = 1;
        return fib(n, 0, f0, f1);
    }

    private static long fib(int n, int cur, long n1, long n2) {
        if (cur == n)
            return n1;
        else
            return fib(n, cur + 1, n2, n1 + n2);
    }

    /**
     * Works up to about n = 9840. (Depends on computer, I think) Stack overflow
     * after that. This can probably be better if a loop is used. Then the digits
     * can be much much larger.
     * 
     * @param n the number in the fibbonaci sequence
     * @return the n'th fibbonaci number
     */
    public static BigInteger betterFib(int n) {
        if (n < 0)
            throw new IllegalArgumentException("n must be non-negative");
        BigInteger f0 = BigInteger.ZERO;
        BigInteger f1 = BigInteger.ONE;
        return fib(n, 0, f0, f1);
    }

    private static BigInteger fib(int n, int cur, BigInteger n1, BigInteger n2) {
        if (cur == n)
            return n1;
        else
            return fib(n, cur + 1, n2, n1.add(n2));
    }

    /**
     * Let's see how much better we can do with loops. Seems like for n > 21000, the
     * BigInteger can't be printed out. There is no practical limit otherwise (even
     * when n = Integer.MAX_VALUE, because no error, like StackOverflow occurs)
     * 
     * @param n the number in the fibbonaci sequence
     * @return the n'th fibbonaci number
     */
    public static BigInteger loopFib(int n) {
        if (n < 0)
            throw new IllegalArgumentException("n must be non-negative");
        BigInteger f0 = BigInteger.ZERO;
        BigInteger f1 = BigInteger.ONE;
        BigInteger temp;
        for (long i = 0; i < n; i++) {
            temp = f0.add(f1);
            f0 = f1;
            f1 = temp;
        }
        // i == n now
        return f0;
    }

    /**
     * 
     * @return a list of all subset totals of the numbers 1 to n inclusive. Does not
     *         ensure any ordering.
     *         <p>
     *         e.g. makeAllSums(3) returns a List [0, 3, 2, 5, 1, 4, 3, 6]
     *         </p>
     */
    public static ArrayList<Integer> makeAllSums(int n) {
        ArrayList<Integer> sums = new ArrayList<>();
        makeSums(n, 0, sums);
        return sums;
    }

    private static void makeSums(int n, int sum, List<Integer> list) {
        if (n == 0)
            list.add(sum);
        // Does not support negative
        else {
            makeSums(n - 1, sum, list);
            makeSums(n - 1, sum + n, list);
        }
    }
}
