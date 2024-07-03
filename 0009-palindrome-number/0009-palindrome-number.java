class Solution {
    public boolean isPalindrome(int x) {
        if(x<0)
        {
            return false;
        }
        int revnum=0;
        int dup=x;
        while(x!=0)
        {
            int rem=x%10;
            x=x/10;
            if(revnum > Integer.MAX_VALUE/10 || revnum==Integer.MAX_VALUE/10 && rem>7)
            {
                return false;
            }
            revnum=(revnum*10) + rem;
        }
        return revnum==dup;
    }
}