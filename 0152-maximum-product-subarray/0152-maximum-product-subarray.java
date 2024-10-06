class Solution {
    public int maxProduct(int[] nums) {
       int n = nums.length, res = nums[0];
       long l = 1, r = 1;
        for (int i = 0; i < n; i++) {
            l =  (l == 0 ? 1 : l) * nums[i];
            r =  (r == 0 ? 1 : r) * nums[n - 1 - i];
            res = (int) Math.max(res, Math.max(l, r));
        }
        return res;
    }
}