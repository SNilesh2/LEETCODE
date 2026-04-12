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
    public int distributeCoins(TreeNode root) {
        int[] ans = new int[1];
        findMinimumMoves(root,ans);
        return ans[0];
    }
    public static int findMinimumMoves(TreeNode root,int[] ans)
    {
        if(root==null)
        {
            return 0;
        }

        if(root.left==null && root.right==null)
        {
            if(root.val==0)
            {
                return -1;
            }
            else
            {
                return root.val-1;
            }
        }

        int left = findMinimumMoves(root.left,ans);

        int right = findMinimumMoves(root.right,ans);

        ans[0] = ans[0] + Math.abs(left) + Math.abs(right);

        if(root.val>0)
        {
            return left + right + (root.val - 1);
        }

        return (left + right) - 1;
    }
}