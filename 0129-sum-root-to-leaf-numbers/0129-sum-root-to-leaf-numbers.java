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
    public int sumNumbers(TreeNode root) {
        int[] result = new int[1];
        findSum(root,result,0);
        return result[0];
    }
    public static void findSum(TreeNode root,int[] result,int sum)
    {
        if(root==null)
        {
            return;
        }

        if(root.left==null && root.right==null)
        {
            result[0] = result[0] + (sum * 10 + root.val);
            return;
        }

        findSum(root.left,result,sum * 10 + root.val);

        findSum(root.right,result,sum * 10 + root.val);
    }
}