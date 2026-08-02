class Solution {
    public int pivotInteger(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            int sum1 = mid * (mid + 1) / 2;
            int sum2 = (n * (n + 1) / 2) - ((mid - 1) * (mid) / 2);

            if (sum1 == sum2)
                return mid;
            else if (sum1 < sum2) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}