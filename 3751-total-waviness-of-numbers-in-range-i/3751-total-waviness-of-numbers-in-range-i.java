class Solution {
    public int totalWaviness(int num1, int num2) {
        int result = 0;
        for(int i=num1;i<=num2;i++)
        {
            String numString = Integer.toString(i);

            for(int j=1;j<numString.length()-1;j++)
            {
                if(numString.charAt(j-1) < numString.charAt(j) && numString.charAt(j) > numString.charAt(j+1))
                {
                    result++;
                }
                if(numString.charAt(j-1) > numString.charAt(j) && numString.charAt(j) < numString.charAt(j+1))
                {
                    result++;
                }
            }
        }

        return result;
    }
}