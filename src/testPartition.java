import org.junit.Assert.*;
import java.util.Random;

public class testPartition {

  @Test(expected=AssertionError)
  public void testAssertionEnabled() {
    assert false;
  }

  private void testArrayPivoted(int[] arr, int pivotIndex, int start, int end) {
    int pivot = arr[pivotIndex];
    for (int i = start; i < pivotIndex; i++) {
      assertTrue("Vals on the left of pivot should be < pivot", arr[i] <= pivot);
    }

    for (int i = pivotIndex; i <= end; i++) {
      assertTrue("Vals on the right of pivot should be > pivot", arr[i] >= pivot);
    }
  }

  private int[] generateIntArray(int size, int min, int max) {
    int[] a = new int[size];
    int range = max + 1 - min;
    for (int i = 0; i < size; i++) {
      a[i] = Random.nextInt(range) + min;
    }

    return a;
  }
}
