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
    public int getMinimumDifference(TreeNode root) {
        int[] ans = new int[1];
        Integer[] prev = new Integer[1];
        prev[0] = null;
        ans[0] = Integer.MAX_VALUE;
        helper(root,ans,prev);
        return ans[0];
    }

    public static void helper(TreeNode root,int[] ans,Integer[] prev)
    {
        if(root==null)
        {
            return;
        }

        helper(root.left,ans,prev);

        if(prev[0] !=null)
        {
            System.out.println(ans[0]);
            ans[0] = Math.min(ans[0],root.val - prev[0]);
        }
        prev[0] = root.val;

        helper(root.right,ans,prev);
    }
}