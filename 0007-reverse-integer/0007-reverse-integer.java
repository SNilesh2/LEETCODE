class Solution {
    public int reverse(int x) {
        int revnum=0;
        while(x!=0)
        {
            int rem=x%10;
            x=x/10;
            if(revnum>Integer.MAX_VALUE/10 || revnum==Integer.MAX_VALUE/10 && rem>7)
            {
                return 0;
            }
            if(revnum<Integer.MIN_VALUE/10 || revnum==Integer.MIN_VALUE/10 && rem<-8)
            {
                return 0;
            }
            revnum=(revnum*10) + rem;
        }
        return revnum;
    }
}