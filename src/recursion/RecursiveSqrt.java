/**
 * 
 */
package recursion;

/**
 * @author ruosh
 *         <p>
 *         A class that contains method for finding the sqrt. Uses the Newton's
 *         Square Root Approximation.
 *         </p>
 * @see <a href="http://www.stuycs.org/courses/apcs2/k/2019-01-30">Assignment
 *      Website</>
 */
public class RecursiveSqrt {
    
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
    
    public static void main(String...args) {
        System.out.println(sqrt(1));
    }
}
