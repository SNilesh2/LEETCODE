class Solution {
    public int minLengthAfterRemovals(String s) {
        int len=s.length();
        int countA=0;
        int countB=0;
        for(int i=0;i<len;i++)
        {
            if(s.charAt(i)=='a')
            {
                countA++;
            }
            else
            {
                countB++;
            }
        }
        return (countA>countB) ? countA-countB : countB-countA ;
    }
}