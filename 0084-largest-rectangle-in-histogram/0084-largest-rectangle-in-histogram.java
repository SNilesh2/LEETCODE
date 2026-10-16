class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] nse = findNse(heights);
        int[] pse = findPse(heights);

        int result = 0;
        for(int i=0;i<heights.length;i++)
        {
            int width = nse[i] - pse[i] - 1;
            int height = heights[i] * width;
            result = Math.max(result,height);
        }

        return result;
    }

    public int[] findNse(int[] heights)
    {
        int[] nse = new int[heights.length];
        Stack<Integer> st = new Stack<>();

        for(int i=heights.length-1;i>=0;i--)
        {
            while(!st.isEmpty() && heights[st.peek()] >= heights[i])
            {
                st.pop();
            }

            nse[i] = st.isEmpty() ? heights.length : st.peek();

            st.push(i);
        }

        return nse;
    }


    public int[] findPse(int[] heights)
    {
        int[] pse = new int[heights.length];
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<heights.length;i++)
        {
            while(!st.isEmpty() && heights[st.peek()] >= heights[i])
            {
                st.pop();
            }

            pse[i] = st.isEmpty() ? -1 : st.peek();

            st.push(i);
        }

        return pse;
    }
}