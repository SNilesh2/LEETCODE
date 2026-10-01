class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int[] arr = new int[256];
        Arrays.fill(arr,-1);
        int longest = 0;
        while(right<s.length())
        {
            int ind = (int)s.charAt(right) ;
            
            while(arr[ind]>=left && arr[ind]<right)
            {
                left++;
            }

            if(arr[ind]<left)
            {
                longest = Math.max(longest, right - left + 1);
            }

            arr[ind] = right;
            right++;
        }
        
        return longest;
    }
}