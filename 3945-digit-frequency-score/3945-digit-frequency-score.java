class Solution {
    public int digitFrequencyScore(int n) {
        int[] freq = new int[10];

        while(n > 0)
        {
            int lastDigit = n % 10;
            freq[lastDigit]++;
            n = n/10;
        }

        int result = 0;

        for(int i=1;i<10;i++)
        {
            result = result + (i * freq[i]);
        }

        return result;
    }
}