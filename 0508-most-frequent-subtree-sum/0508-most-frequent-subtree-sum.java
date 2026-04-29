/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int[] findFrequentTreeSum(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();

        findAllSum(root,map);

        int max = Integer.MIN_VALUE;
        for(Integer val : map.values())
        {
            if(val > max)
            {
                max = val;
            }
        }

        for(Map.Entry<Integer,Integer> en : map.entrySet())
        {
            if(en.getValue()==max)
            {
                list.add(en.getKey());
            }
        }

        int size = list.size();

        int[] result = new int[size];

        for(int i=0;i<size;i++)
        {
            result[i] = list.get(i);
        }

        return result;
    }

    public static int findAllSum(TreeNode root,HashMap<Integer,Integer> map)
    {
        if(root==null)
        {
            return 0;
        }

        int left = findAllSum(root.left,map);

        int right = findAllSum(root.right,map);

        int sum = left + right + root.val;

        if(map.containsKey(sum))
        {
            map.put(sum,map.get(sum)+1);
        }
        else
        {
            map.put(sum,1);
        }

        return sum;
    }
}