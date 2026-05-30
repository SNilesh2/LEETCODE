class Solution {
    public List<String> stringSequence(String target) {
        List<String> result = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        sb.append('a');
        int i=0;
        while(i<target.length())
        {
            if(target.charAt(i) == sb.charAt(i))
            {
                result.add(sb.toString());
                sb.append('a');
                i++;
            }
            else
            {
                result.add(sb.toString());
                sb.deleteCharAt(sb.length()-1);
                for(char c = 'b';c < target.charAt(i);c++)
                {
                    sb.append(c);
                    result.add(sb.toString());
                    sb.deleteCharAt(sb.length()-1);
                }
                sb.append(target.charAt(i));
                result.add(sb.toString());
                sb.append('a');
                i++;
            }
        }
        return result;
    }
}