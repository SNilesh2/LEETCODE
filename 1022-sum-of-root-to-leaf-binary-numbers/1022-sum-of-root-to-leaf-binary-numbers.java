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
    public int sumRootToLeaf(TreeNode root) {
        int[] ans = new int[1];
        String str = "";
        helper(root,str,ans);
        return ans[0];
    }

    public static void helper(TreeNode root,String str,int[] ans)
    {
        if(root==null)
        {
            return;
        }
        if(root.left==null && root.right==null)
        {
            str = str + Integer.toString(root.val);
            int val = Integer.parseInt(str,2);
            ans[0] = ans[0] + val;
            return;
        }

        helper(root.left,str+Integer.toString(root.val),ans);

        helper(root.right,str+Integer.toString(root.val),ans);
    }
}