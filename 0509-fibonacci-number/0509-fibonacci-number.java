class Solution {
    public int fib(int n) {
        if(n==0)
        {
            return 0;
        }

        int[] memo = new int[n+1];
        Arrays.fill(memo,-1);
        return fibo(n,memo);
    }

    public static int fibo(int n,int[] memo)
    {
        if(memo[n]!=-1)
        {
            return memo[n];
        }

        if(n<=2)
        {
            return 1;
        }

        return memo[n] = fibo(n-1,memo) + fibo(n-2,memo);
    }
}