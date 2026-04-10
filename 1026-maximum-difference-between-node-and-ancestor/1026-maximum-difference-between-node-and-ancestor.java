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
    public int maxAncestorDiff(TreeNode root) {
        int[] ans = new int[1];
        findMaxDiff(root,ans);
        return ans[0];
    }


    public static int[] findMaxDiff(TreeNode root,int[] ans)
    {
        if(root==null)
        {
            return new int[] {Integer.MAX_VALUE,Integer.MIN_VALUE};
        }

        if(root.left==null && root.right==null)
        {
            return new int[] {root.val,root.val};
        }

        int[] left = findMaxDiff(root.left,ans);

        int[] right = findMaxDiff(root.right,ans);

        int min = Math.min(left[0],right[0]);

        int max = Math.max(left[1],right[1]);

        ans[0] = Math.max(ans[0],Math.max(Math.abs(min-root.val),Math.abs(max-root.val)));

        min = Math.min(min,root.val);
        max = Math.max(max,root.val);

        return new int[] {min,max};
    }
}