class Pair
{
    String str;
    int level;
    public Pair(String str,int level)
    {
        this.str = str;
        this.level = level;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        HashSet<String> set = new HashSet<>();
        for(String s : wordList)
        {
            set.add(s);
        }

        if(!set.contains(endWord))
        {
            return 0;
        }

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord,1));

        while(!q.isEmpty())
        {
            Pair p = q.poll();

            String str = p.str;
            int level = p.level;
            if(str.equals(endWord))
            {
                return level;
            }

            for(int i=0;i<str.length();i++)
            {
                StringBuilder sb = new StringBuilder(str);
                for(char c='a';c<='z';c++)
                {
                    if(str.charAt(i)==c)
                    {
                        continue;
                    }

                    sb.setCharAt(i,c);
                    if(set.contains(sb.toString()))
                    {
                        q.add(new Pair(sb.toString(),level + 1));
                        set.remove(sb.toString());
                    }
                }
            }
        }

        return 0;
    }
}