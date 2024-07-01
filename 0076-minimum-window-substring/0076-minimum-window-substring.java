class Solution {
    public String minWindow(String s, String t) {
        if(s.length()==0 || t.length()==0)
        {
            return "";
        }
        Map<Character,Integer> tfreq=new HashMap<>();
        for(char c:t.toCharArray())
        {
            tfreq.put(c,tfreq.getOrDefault(c,0)+1);
        }
        int required=tfreq.size();
        int formed=0;
        int left=0,right=0;
        int[] ans={-1,0,0};
        Map<Character,Integer> windowfreq=new HashMap<>();
        while(right<s.length())
        {
            char c=s.charAt(right);
            windowfreq.put(c,windowfreq.getOrDefault(c,0)+1);
            if(tfreq.containsKey(c) && windowfreq.get(c).intValue()==tfreq.get(c).intValue())
            {
                formed++;
            }
            while(left<=right && formed==required)
            {
                c=s.charAt(left);
                if(ans[0]==-1 || right-left+1<ans[0])
                {
                    ans[0]=right-left+1;
                    ans[1]=left;
                    ans[2]=right;
                }
                windowfreq.put(c,windowfreq.get(c)-1);
                if(tfreq.containsKey(c) && windowfreq.get(c).intValue()<tfreq.get(c).intValue())
                {
                    formed--;
                }
                left++;
            }
            right++;
        }
        return ans[0]==-1 ? "":s.substring(ans[1],ans[2]+1);
    }
}