class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set=new HashSet<>();
        int left=0,right=0;
        int maxlength=0;
        while(right<s.length())
        {
            if(!set.contains(s.charAt(right)))
            {
                set.add(s.charAt(right));
                right++;
                maxlength=Math.max(maxlength,right-left);
            }
            else
            {
                set.remove(s.charAt(left));
                left++;
            }
        }
        return maxlength;
    }
}