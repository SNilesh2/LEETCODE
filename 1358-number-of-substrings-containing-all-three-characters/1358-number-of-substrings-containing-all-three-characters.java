class Solution {
    public int numberOfSubstrings(String s) {
        int left = 0;
        int right = 0;
        int total = 0;

        HashMap<Character,Integer> map = new HashMap<>();

        while(right < s.length())
        {
            map.put(s.charAt(right),map.getOrDefault(s.charAt(right),0)+1);

            while(map.size()==3)
            {
                total = total + (s.length() - right);
                
                map.put(s.charAt(left),map.get(s.charAt(left))-1);
                if(map.get(s.charAt(left))==0)
                {
                    map.remove(s.charAt(left));
                }
                left++;
            }

            right++;
        }

        return total;
    }
}