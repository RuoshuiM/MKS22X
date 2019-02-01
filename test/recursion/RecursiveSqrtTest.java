package recursion;

import static org.junit.Assert.*;

import org.junit.Test;

public class RecursiveSqrtTest {

    private final double tolerance = 0.00001;

    /*
     * Testing Strategy: n = 0, 0 < n < 1, n = 1, n < 1
     * 
     * Each part covered by at least one case below
     */

    @Test(expected = AssertionError.class)
    public void testAssertionEnabled() {
        assert false; // make sure assertions are enabled with VM argument: -ea
    }

    @Test
    public void testZero() {
        double n = 0;
        assertEquals(RecursiveSqrt.sqrt(n), Math.sqrt(n), tolerance * n);
    }

    @Test
    public void testOne() {
        double n = 1;
        assertEquals(RecursiveSqrt.sqrt(n), Math.sqrt(n), tolerance * n);
    }

    @Test
    public void testLessThanOne() {
        double[] nums = new double[] { 0.99999, 0.5, 0.1, 0.08, 0.05, 0.01, 0.0006, 0.00047, 0.25641, 0.0000006 };
        for (double n : nums) {
            assertEquals(RecursiveSqrt.sqrt(n), Math.sqrt(n), tolerance * n);
        }
    }

    @Test
    public void testGreaterThanOne() {
        double[] nums = new double[] { 4, 8, 10, 12, 14, 16, 17, 15, 240, 865, 100, 50, 25 };
        for (double n : nums) {
            assertEquals(RecursiveSqrt.sqrt(n), Math.sqrt(n), tolerance * n);
        }
    }

    @Test
    public void testLargeN() {
        double[] nums = new double[] { 100000000, 50000000, 46745425657464.667645, 123456789.10,
                546454545.79867787e10 };
        for (double n : nums) {
            assertEquals(RecursiveSqrt.sqrt(n), Math.sqrt(n), tolerance * n);
        }
    }

}
