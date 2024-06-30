class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length()==0)
        {
            return true;
        }
        int spointer=0;
        int tpointer=0;
        while(tpointer<t.length())
        {
            if(s.charAt(spointer)==t.charAt(tpointer))
            {
                spointer++;
                if(spointer==s.length())
                {
                    return true;
                }
            }
            tpointer++;
        }
        return false;
    }
}