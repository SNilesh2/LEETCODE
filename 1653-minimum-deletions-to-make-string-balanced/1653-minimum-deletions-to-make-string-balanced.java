class Solution {
    public int minimumDeletions(String s) {
        int bcount=0;
        int len = s.length();
        int deletions = 0;
        for(int i=0;i<len;i++)
        {
            if(s.charAt(i)=='b')
            {
                bcount++;
            }
            else
            {
                deletions = Math.min(deletions+1,bcount);
            }
        }
        return deletions;
    }
}