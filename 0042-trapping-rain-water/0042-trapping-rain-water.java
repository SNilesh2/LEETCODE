class Solution {
    public int trap(int[] height) {
        int[] nge = findNge(height);
        int[] pge = findPge(height);

        int result = 0;
        for(int i=0;i<height.length;i++)
        {
            int diff = Math.min(nge[i],pge[i]);

            if(diff==0)
            {
                continue;
            }

            result = result + (diff - height[i]);
        }

        return result;
    }

    public int[] findNge(int[] height)
    {
        int length = height.length;
        int[] nge = new int[length];
        Stack<Integer> st = new Stack<>();

        for(int i = height.length-1;i>=0;i--)
        {
            while(!st.isEmpty() && st.peek() <= height[i])
            {
                st.pop();
            }

            nge[i] = st.isEmpty() ? 0 : st.peek();

            if(st.isEmpty() || st.peek() < height[i])
            {
                st.push(height[i]);
            }
        }

        return nge;
    }

    public int[] findPge(int[] height)
    {
        int length = height.length;
        int[] pge = new int[length];
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<length;i++)
        {
            while(!st.isEmpty() && st.peek() <= height[i])
            {
                st.pop();
            }

            pge[i] = st.isEmpty() ? 0 : st.peek();

            if(st.isEmpty() || st.peek() < height[i])
            {
                st.push(height[i]);
            }
        }

        return pge;
    }
}