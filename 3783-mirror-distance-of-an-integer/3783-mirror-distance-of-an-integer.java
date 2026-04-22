class Solution {
    public int mirrorDistance(int n) {
        int tempN = n;
        int reversed = 0;

        while(n>0)
        {
            int last = n % 10;
            reversed = reversed * 10 + last;
            n = n/10;
        }
        return Math.abs(tempN - reversed);
    }
}