
public class Subarray {

    public class Res {

        int leftIndex;
        int rightIndex;
        int sum;

        public Res(int leftIndex, int rightIndex, int sum) {
            this.leftIndex = leftIndex;
            this.rightIndex = rightIndex;
            this.sum = sum;
        }

    }

    public Res findMaxCrossingSubarray(int[] a, int low, int mid, int high) {

        int leftSum = Integer.MIN_VALUE;
        int rightSum = Integer.MIN_VALUE;
        int sum = 0;
        int leftMax = 0;
        int rightMax = 0;
        for (int i = mid; i >= low; i--) {
            sum += a[i];
            if (sum > leftSum) {
                leftSum = sum;
                leftMax = i;
            }
        }
        sum = 0;
        for (int j = mid + 1; j <= high; j++) {
            sum += a[j];
            if (sum > rightSum) {
                rightSum = sum;
                rightMax = j;
            }
        }
        return new Res(leftMax, rightMax, leftSum + rightSum);
    }

    public Res findMaxSubarray(int[] a, int low, int high) {
        if (low == high) {
            return new Res(low, high, a[low]);
        } else {
            int mid = (low + high) / 2;
            Res left = findMaxSubarray(a, low, mid);
            Res right = findMaxSubarray(a, mid + 1, high);
            Res cross = findMaxCrossingSubarray(a, low, mid, high);
            if (left.sum >= right.sum && left.sum >= cross.sum) {
                return new Res(left.leftIndex, left.rightIndex, left.sum);
            } else if (right.sum >= left.sum && right.sum >= cross.sum) {
                return new Res(right.leftIndex, right.rightIndex, right.sum);
            } else {
                return new Res(cross.leftIndex, cross.rightIndex, cross.sum);
            }
        }
    }
}
