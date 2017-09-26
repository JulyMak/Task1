import org.junit.Test;

import static org.junit.Assert.*;

public class SubarrayTest {

    @Test
    public void findMaxSubarray() throws Exception {
        int[] prices = {100, 113, 110, 85, 105, 102, 86, 63, 81, 101, 94, 106, 101, 79, 94};
        int left = 7;
        int right = 10;
        int sum = 43;
        check(prices, left, right, sum);
    }

    @Test
    public void findMaxSubarray1() throws Exception {
        int[] prices = {10, 11, 7, 10, 6};
        int left = 2;
        int right = 2;
        int sum = 3;
        check(prices, left, right, sum);
    }

    @Test
    public void findMaxSubarray2() throws Exception {
        int[] prices = {1, 2, 7, 10, 18};
        int left = 0;
        int right = 3;
        int sum = 17;
        check(prices, left, right, sum);
    }

    @Test
    public void findMaxSubarray3() throws Exception {
        int[] prices = {5, 4, 3, 2, 1};
        int left = 0;
        int right = 0;
        int sum = 0;
        check(prices, left, right, sum);
    }

    public void check(int[] prices, int left, int right, int sum) {
        Subarray sub = new Subarray();
        int[] delt = new int[prices.length - 1];
        for (int i = 0; i < prices.length - 1; i++) {
            delt[i] = prices[i + 1] - prices[i];
        }
        Subarray.Res res = sub.findMaxSubarray(delt, 0, delt.length - 1);
        assertEquals(left, res.leftIndex);
        assertEquals(right, res.rightIndex);
        assertEquals(sum, res.sum);
    }

}