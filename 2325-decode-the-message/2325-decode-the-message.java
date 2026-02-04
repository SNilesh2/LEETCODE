class Solution {
    public String decodeMessage(String key, String message) {
        HashMap<Character,Character> map=new HashMap<>();
        int n=key.length();
        char c='a';
        for(int i=0;i<n;i++)
        {
            if(map.containsKey(key.charAt(i)) || key.charAt(i)==' ')
            {
                continue;
            }
            else
            {
                map.put(key.charAt(i),c);
                c++;
            }
        }

        System.out.println(map);

        StringBuilder sb=new StringBuilder();

        int len=message.length();
        for(int i=0;i<len;i++)
        {
            if(message.charAt(i)==' ')
            {
                sb.append(' ');
            }
            else
            {
                sb.append(map.get(message.charAt(i)));
            }
        }

        return sb.toString();
    }
}