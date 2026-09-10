class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] hash = new int[256];
        Arrays.fill(hash,-1);

        int left = 0;
        int right = 0;

        int maxLength = 0;
        while(right < s.length())
        {
            if(hash[s.charAt(right)]!=-1 && hash[s.charAt(right)] >= left)
            {
                left = hash[s.charAt(right)] + 1;
                hash[s.charAt(right)] = right;
                maxLength = Math.max(maxLength,right - left + 1);
            }
            else
            {
                hash[s.charAt(right)] = right;
                maxLength = Math.max(maxLength,right - left + 1);
            }
            right++;
        }
        return maxLength;
    }
}