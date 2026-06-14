class Solution {
    public int countDigits(int num) {
        int count = 0;
        int n = num;
        while(n>0)
        {
            int lastDigit = n % 10;

            if(num % lastDigit == 0)
            {
                count++;
            }

            n = n/10;
        }

        return count;
    }
}