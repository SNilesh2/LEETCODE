class Solution {
    public String minRemoveToMakeValid(String s) {
        int len = s.length();
        StringBuilder sb=new StringBuilder();
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<len;i++)
        {
            if(s.charAt(i)=='(')
            {
                st.push(sb.length());
                sb.append(s.charAt(i));
            }
            else if(s.charAt(i)==')')
            {
                if(!st.isEmpty())
                {
                    sb.append(s.charAt(i));
                    st.pop();
                }
            }
            else
            {
                sb.append(s.charAt(i));
            }
        }

        while(!st.isEmpty())
        {
            sb.deleteCharAt(st.pop());
        }
        return sb.toString();
    }
}