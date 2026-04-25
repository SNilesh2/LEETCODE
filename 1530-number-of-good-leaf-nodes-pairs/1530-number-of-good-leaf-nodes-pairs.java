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
    public int countPairs(TreeNode root, int distance) {
        int[] ans = new int[1];
        findCount(root,distance,ans);
        return ans[0];
    }
    public static List<Integer> findCount(TreeNode root,int distance,int[] ans)
    {
        if(root==null)
        {
            return new ArrayList<>();
        }

        if(root.left==null && root.right==null)
        {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            return list;
        }

        List<Integer> left = findCount(root.left,distance,ans);

        List<Integer> right = findCount(root.right,distance,ans);
        
        for(int i=0;i<left.size();i++)
        {
            for(int j=0;j<right.size();j++)
            {
                if(left.get(i) + right.get(j) <= distance)
                {
                    ans[0]++;
                }
            }
        }

        List<Integer> leftAndRight = new ArrayList<>();
        for(int i=0;i<left.size();i++)
        {
            leftAndRight.add(left.get(i)+1);
        }
        for(int i=0;i<right.size();i++)
        {
            leftAndRight.add(right.get(i)+1);
        }

        return leftAndRight;
    }
}