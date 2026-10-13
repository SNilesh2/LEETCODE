class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<asteroids.length;i++)
        {
            if(asteroids[i] > 0)
            {
                st.push(asteroids[i]);
            }
            else
            {
                while(!st.isEmpty() && st.peek() > 0 && Math.abs(st.peek()) < Math.abs(asteroids[i]))
                {
                    st.pop();
                }

                if(!st.isEmpty() && st.peek() > 0 && Math.abs(st.peek()) == Math.abs(asteroids[i]))
                {
                    st.pop();
                    continue;
                }

                if(st.isEmpty() || st.peek()<0)
                {
                    st.push(asteroids[i]);
                }
            }
        }

        int size = st.size();

        ArrayList<Integer> list = new ArrayList<>();        
        while(!st.isEmpty())
        {
            list.add(st.pop());
        }

        Collections.reverse(list);

        int[] result = new int[size];

        for(int i=0;i<size;i++)
        {
            result[i] = list.get(i);
        }
        
        return result;
    }
}