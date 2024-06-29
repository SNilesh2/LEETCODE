class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
         int totalgas=0,totalcost=0,startindex=0,tank=0;
         for(int i=0;i<gas.length;i++)
         {
            totalgas=totalgas+gas[i];
            totalcost=totalcost+cost[i];
            tank=tank+gas[i]-cost[i];
            if(tank<0)
            {
                startindex=i+1;
                tank=0;
            }
         }
         if(totalgas<totalcost)
         {
            return -1;
         }
         else
         {
            return startindex;
         }
    }
}