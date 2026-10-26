class Solution {
    public int candy(int[] ratings) {
        
        int i = 1;
        int sum = 1;

        while(i < ratings.length)
        {
            if(ratings[i] == ratings[i-1])
            {
                sum = sum + 1;
                i++;
                continue;
            }

            int peak = 1;
            while(i < ratings.length && ratings[i-1] < ratings[i])
            {
                peak = peak + 1;
                sum = sum + peak;
                i++;
            }

            int down = 1;
            while(i < ratings.length && ratings[i-1] > ratings[i])
            {
                sum = sum + down;
                down = down + 1;
                i++;
            }

            if(down > peak)
            {
                sum = sum + (down - peak);
            }
        }

        return sum;
    }
}