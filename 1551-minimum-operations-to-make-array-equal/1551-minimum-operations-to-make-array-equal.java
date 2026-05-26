class Solution {
    public int minOperations(int n) {

        int mid = (1 + (((n-1) * 2)+1))/2;

        int result = 0;
        for(int i=1;i<mid;i=i+2)
        {
            result = result + (n - i);
        }

        return result;
    }
}