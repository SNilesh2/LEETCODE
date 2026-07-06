class Solution {
    public int prefixCount(String[] words, String pref) {
        int count = 0;
        int prefLength = pref.length();
        for(String word : words)
        {
            if(word.length() < prefLength)
            {
                continue;
            }
            int i;
            for(i=0;i<prefLength;i++)
            {
                if(pref.charAt(i) != word.charAt(i))
                {
                    break;
                }
            }
            if(i==prefLength)
            {
                count++;
            }
        }
        return count;
    }
}