class Solution {
    public String sortSentence(String s) {
        String[] words = s.split(" ");

        HashMap<Integer,String> map = new HashMap<>();

        for(int i=0;i<words.length;i++)
        {
            StringBuilder word = new StringBuilder(words[i]);
            int index = word.charAt(word.length()-1) - '0';
            word = word.deleteCharAt(word.length()-1);
            map.put(index,word.toString());
        }

        StringBuilder res = new StringBuilder();
        for(int i=1;i<=words.length;i++)
        {
            res.append(map.get(i));
            if(i!=words.length)
            {
                res.append(" ");
            }
        }

        return res.toString();
    }
}