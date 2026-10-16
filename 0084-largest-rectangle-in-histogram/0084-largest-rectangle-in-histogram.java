class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();

        int result = 0;
        for(int i=0;i<heights.length;i++)
        {
            while(!st.isEmpty() && heights[st.peek()] >= heights[i])
            {
                int height = heights[st.pop()];
                int pse = st.isEmpty() ? -1 : st.peek();
                int nse = i;
                int area = height * (nse - pse - 1);
                result = Math.max(result,area);
            }
            st.push(i);
        }

        while(!st.isEmpty())
        {
            int height = heights[st.pop()];
            int nse = heights.length;
            int pse = st.isEmpty() ? -1 : st.peek();
            int area = height * (nse - pse - 1);
            result = Math.max(result,area);
        }

        return result;
    }
}