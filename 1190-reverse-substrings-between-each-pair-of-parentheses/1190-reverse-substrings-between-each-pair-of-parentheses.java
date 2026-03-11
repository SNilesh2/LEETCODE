class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> st=new Stack<>();
        int len=s.length();
        for(int i=0;i<len;i++)
        {
            if(s.charAt(i)==')')
            {
                StringBuilder sb=new StringBuilder();
                while(st.peek()!='(')
                {
                    sb.append(st.pop());
                }
                System.out.println(sb.toString());
                st.pop();
                for(int j=0;j<sb.length();j++)
                {
                    st.push(sb.charAt(j));
                }
            }
            else
            {
                st.push(s.charAt(i));
            }
        }

        StringBuilder result = new StringBuilder();

        while(!st.isEmpty())
        {
            result.append(st.pop());
        }
        return result.reverse().toString();
    }
}