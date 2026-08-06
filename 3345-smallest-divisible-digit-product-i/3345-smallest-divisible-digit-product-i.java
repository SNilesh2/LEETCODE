class Solution {
    public int smallestNumber(int n, int t) {
        int num = n;
        while(num <= Integer.MAX_VALUE)
        {
            int prod = 1;
            int temp = num;
            while(temp > 0)
            {
                int lastDigit = temp % 10;
                prod = prod * lastDigit;
                temp = temp / 10;
            }
            
            if(prod % t == 0)
            {
                return num;
            }
            num++;
        }

        return -1;
    }
}