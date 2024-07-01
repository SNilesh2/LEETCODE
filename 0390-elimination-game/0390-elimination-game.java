class Solution {
    public int lastRemaining(int n) {
        int head=1;
        int step=1;
        boolean left=true;
        while(n>1)
        {
            if(left || n%2==1)
            {
                head=head+step;
            }
            n=n/2;
            step=step*2;
            left=!left;
        }
        return head;
    }
}