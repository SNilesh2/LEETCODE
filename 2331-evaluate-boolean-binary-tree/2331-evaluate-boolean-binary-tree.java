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
    public boolean evaluateTree(TreeNode root) {
        return helper(root);
    }
    public static boolean helper(TreeNode root)
    {
        if(root.left==null && root.right==null)
        {
            if(root.val==1)
            {
                return true;
            }
            return false;
        }

        boolean left = helper(root.left);

        boolean right = helper(root.right);

        if(root.val == 2)
        {
            return left || right; 
        }

        return left && right;
    }
}