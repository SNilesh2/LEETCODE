class Pair
{
    String str;
    Integer cnt;
    Pair(String _str,Integer _cnt)
    {
        this.str=_str;
        this.cnt=_cnt;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set=new HashSet<>();
        for(String s:wordList)
        {
            set.add(s);
        }
        Queue<Pair> q=new LinkedList<>(); 
        if(set.contains(beginWord)==true)
        {
            set.remove(beginWord);
        }
        q.add(new Pair(beginWord,1));
        while(!q.isEmpty())
        {
            Pair pr=q.poll();
            String str=pr.str;
            Integer cnt=pr.cnt;
            if(str.equals(endWord)==true) return cnt;
            for(int i=0;i<str.length();i++)
            {
                for(char ch='a';ch<='z';ch++)
                {
                    char[] replace=str.toCharArray();
                    replace[i]=ch;
                    String s=new String(replace);
                    if(set.contains(s)==true)
                    {
                        set.remove(s);
                        q.add(new Pair(s,cnt+1));
                    }
                }
            }
        }
        return 0;
    }
}