class Pair
{
    int temperature;
    int ind;
    public Pair(int temperature ,int ind)
    {
        this.temperature = temperature;
        this.ind = ind;
    }
}
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] result = new int[len];
        result[len-1]=0;
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(temperatures[len-1],len-1));
        for(int i=len-2;i>=0;i--)
        {
            while(!st.isEmpty() && st.peek().temperature<=temperatures[i])
            {
                st.pop();
            }

            if(st.isEmpty())
            {
                result[i]=0;
            }
            else
            {
                result[i] = st.peek().ind - i;
            }
            st.push(new Pair(temperatures[i],i));
        }
        return result;
    }
}