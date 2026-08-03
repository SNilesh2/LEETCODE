class Solution {
    public int countAsterisks(String s) {
        int i = 0;
        int count = 0;
        while(i < s.length())
        {
            if(s.charAt(i)=='|')
            {
                i++;
                while(s.charAt(i)!='|')
                {
                    i++;
                }
            }

            if(s.charAt(i)=='*')
            {
                count++;
            }

            i++;
        }
        return count;
    }
}