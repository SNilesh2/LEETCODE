class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int right = 0;
        int maxLength = 0;
        int maxf = 0;

        HashMap<Character,Integer> map = new HashMap<>();
        while(right < s.length())
        {
            map.put(s.charAt(right),map.getOrDefault(s.charAt(right),0)+1);

            maxf = Math.max(maxf,map.get(s.charAt(right)));

            int length = right - left + 1;
            if(length - maxf > k)
            {
                map.put(s.charAt(left),map.get(s.charAt(left))-1);
                left++;
                int maxi = 0;
                for(Map.Entry<Character,Integer> en : map.entrySet())
                {
                    maxi = Math.max(maxi,en.getValue());
                }
                maxf = maxi;
            }

            if(length - maxf <= k)
            {
                maxLength = Math.max(maxLength,length);
            }

            right++;
        }

        return maxLength;
    }
}