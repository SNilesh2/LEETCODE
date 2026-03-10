class CustomStack {
    int[] stack;
    int top;
    final int max;
    public CustomStack(int maxSize) {
        max=maxSize;
        stack=new int[max];
        top=0;
    }
    
    public void push(int x) {
        if(top!=max)
        {
            stack[top]=x;
            top++;
        }
    }
    
    public int pop() {
        if(top==0)
        {
            return -1;
        }
        int poped=stack[--top];
        return poped;
    }
    
    public void increment(int k, int val) {
        int toChange=Math.min(top,k);

        for(int i=0;i<toChange;i++)
        {
            stack[i]+=val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */