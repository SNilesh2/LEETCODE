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
    public int rangeSumBST(TreeNode root, int low, int high)  
    {
        int[] ans = new int[1];
        helper(root,low,high,ans);
        return ans[0];
    }

    public static void helper(TreeNode root,int low,int high,int[] ans)
    {
        if(root==null)
        {
            return;
        }

        helper(root.left,low,high,ans);

        helper(root.right,low,high,ans);

        if(root.val>=low && root.val<=high)
        {
            ans[0]=ans[0]+root.val;
        }
    }
}