class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;

        HashMap<Character,Integer> map = new HashMap<>();
        int maxLength = 0;
        while(right < s.length())
        {
            if(map.containsKey(s.charAt(right)))
            {
                map.put(s.charAt(left),map.get(s.charAt(left))-1);
                if(map.get(s.charAt(left))==0)
                {
                    map.remove(s.charAt(left));
                }

                left++;
            }
            else
            {
                map.put(s.charAt(right),map.getOrDefault(s.charAt(right),0)+ 1);
                maxLength = Math.max(maxLength,right - left + 1);
                right++;
            }
        }

        return maxLength;
    }
}