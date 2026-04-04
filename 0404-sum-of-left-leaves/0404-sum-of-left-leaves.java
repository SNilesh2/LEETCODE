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
    public int sumOfLeftLeaves(TreeNode root) {
        int[] ans = new int[1];
        helper(root,ans);
        return ans[0];
    }
    public static int helper(TreeNode root,int[] ans)
    {
        if(root==null)
        {
            return 0;
        }

        if(root.left==null && root.right==null)
        {
            return root.val;
        }

        int left = helper(root.left,ans);

        ans[0] = ans[0] + left;

        helper(root.right,ans);

        return 0;
    }
}