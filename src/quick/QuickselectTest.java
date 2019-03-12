package quick;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

public class QuickselectTest {

    @Test(expected = AssertionError.class)
    public void testAssertionEnabled() {
        assert false;
    }

    @Test
    public void defaultTestCase() {
        int[] ary = { 2, 10, 15, 23, 0, 5 };
        int[] ans = { 0, 2, 5, 10, 15, 23 };
        for (int i = 0; i < 6; i++) {
            assertEquals(ans[i], Quick.quickselect(ary.clone(), i));
        }
    }
}
