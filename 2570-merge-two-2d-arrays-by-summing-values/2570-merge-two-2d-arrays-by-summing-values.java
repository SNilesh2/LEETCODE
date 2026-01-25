class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();

        int n1=nums1.length;
        int n2=nums2.length;

        int p1=0;
        int p2=0;
        while(p1<n1 && p2<n2)
        {
            ArrayList<Integer> temp=new ArrayList<>();
            if(nums1[p1][0]==nums2[p2][0])
            { 
                temp.add(nums1[p1][0]);
                temp.add(nums1[p1][1]+nums2[p2][1]);
                p1++;
                p2++;
            }
            else if(nums1[p1][0]<nums2[p2][0])
            {
                temp.add(nums1[p1][0]);
                temp.add(nums1[p1][1]);
                p1++;
            }
            else
            {
                temp.add(nums2[p2][0]);
                temp.add(nums2[p2][1]);
                p2++;
            }
            result.add(temp);
        }
        while(p1<n1)
        {
            ArrayList<Integer> temp=new ArrayList<>();
            temp.add(nums1[p1][0]);
            temp.add(nums1[p1][1]);
            p1++;
            result.add(temp);
        }
        while(p2<n2)
        {
            ArrayList<Integer> temp=new ArrayList<>();
            temp.add(nums1[p2][0]);
            temp.add(nums1[p2][1]);
            p2++;
            result.add(temp);
        }
        int[][] answer=new int[result.size()][2];
        for(int i=0;i<result.size();i++)
        {
            answer[i][0]=result.get(i).get(0);
            answer[i][1]=result.get(i).get(1);
        }
        return answer;
    }
}