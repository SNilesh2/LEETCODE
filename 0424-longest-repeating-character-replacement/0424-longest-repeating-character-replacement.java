class Solution {
    public int characterReplacement(String s, int k) {
        int left=0,right=0,maxf=0,maxlength=0;
        int[] hash=new int[26];
        while(right<s.length())
        {
            hash[s.charAt(right)-'A']++;
            maxf=Math.max(maxf,hash[s.charAt(right)-'A']);
            if(right-left+1-maxf>k)
            {
                hash[s.charAt(left)-'A']--;
                left++;
            }
            if(right-left+1-maxf<=k)
            {
                maxlength=Math.max(maxlength,right-left+1);
            }
            right++;
        }
        return maxlength;
    }
}