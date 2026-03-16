class Solution {
    public int minLength(String s) {
        int len = s.length();
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < len; i++) 
        {
            if (!st.isEmpty() && s.charAt(i) == 'B' && st.peek()=='A') 
            {
                st.pop();
            }
            else if(!st.isEmpty() && s.charAt(i) == 'D' && st.peek()=='C')
            {
                st.pop();
            }
            else
            {
                st.push(s.charAt(i));
            }
        }
        return st.size();
    }
}