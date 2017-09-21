import org.junit.Test;

import static org.junit.Assert.*;

public class SubarrayTest {
    @Test
    public void findMaxSubarray() throws Exception {
        Subarray sub = new Subarray();
        int[] prices = {100, 113, 110, 85, 105, 102, 86, 63, 81, 101, 94, 106, 101, 79, 94};
        int[] delt = new int[prices.length - 1];
        for (int i = 0; i < prices.length - 1; i++) {
            delt[i] = prices[i + 1] - prices[i];
        }
        Subarray.Res res = sub.findMaxSubarray(delt, 0, delt.length - 1);
        assertEquals(7, res.leftIndex);
        assertEquals(10, res.rightIndex);
        assertEquals(43, res.sum);
    }
    @Test
    public void findMaxSubarray1() throws Exception {
        Subarray sub = new Subarray();
        int[] prices = {10, 11, 7, 10, 6};
        int[] delt = new int[prices.length - 1];
        for (int i = 0; i < prices.length - 1; i++) {
            delt[i] = prices[i + 1] - prices[i];
        }
        Subarray.Res res = sub.findMaxSubarray(delt, 0, delt.length - 1);
        assertEquals(2, res.leftIndex);
        assertEquals(2, res.rightIndex);
        assertEquals(3, res.sum);
    }

}