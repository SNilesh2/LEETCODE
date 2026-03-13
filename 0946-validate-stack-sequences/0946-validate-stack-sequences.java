class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();
        
        int len=pushed.length;
        int j=0;
        int i=0;
        while(i<len && j<len)
        {
            if(pushed[i]==popped[j])
            {
                i++;
                j++;
            }
            else if(!st.isEmpty() && st.peek()==popped[j])
            {
                st.pop();
                j++;
            }
            else
            {
                st.push(pushed[i]);
                i++;
            }
        }

        while(!st.isEmpty())
        {
            if(st.pop()!=popped[j])
            {
                return false;
            }
            j++;
        }
        return true;
    }
}