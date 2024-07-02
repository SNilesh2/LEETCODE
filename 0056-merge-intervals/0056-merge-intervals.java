class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        List<int[]> merged=new ArrayList<>();
        int[] currentinterval=intervals[0];
        merged.add(currentinterval);
        for(int[] interval:intervals)
        {
            int currentstart=currentinterval[0];
            int currentend=currentinterval[1];
            int nextstart=interval[0];
            int nextend=interval[1];
            if(currentend>=nextstart)
            {
                currentinterval[1]=Math.max(currentend,nextend);
            }
            else
            {
                currentinterval=interval;
                merged.add(currentinterval);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}