class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals , (a,b) -> {
            if(a[0]!=b[0])
            {
                return Integer.compare(a[0],b[0]);
            }
            return Integer.compare(a[1],b[1]);
        });

        int result = 0;

        int prevLast = intervals[0][1];
        for(int i=1;i<intervals.length;i++)
        {
            int currentFirst = intervals[i][0];

            if(currentFirst < prevLast)
            {
                result++;
                prevLast = Math.min(prevLast,intervals[i][1]);
            }
            else
            {
                prevLast = intervals[i][1];
            }
        }

        return result;
    }
}