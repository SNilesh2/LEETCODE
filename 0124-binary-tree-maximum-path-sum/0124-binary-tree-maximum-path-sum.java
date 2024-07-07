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
    public int maxPathSum(TreeNode root) {
        int[] maxsum=new int[1];
        maxsum[0]=Integer.MIN_VALUE;
        maximumsum(root,maxsum);
        return maxsum[0];
    }
    public static int maximumsum(TreeNode root,int[] maxsum)
    {
        if(root==null) return 0;
        int lsum=Math.max(0,maximumsum(root.left,maxsum));
        int rsum=Math.max(0,maximumsum(root.right,maxsum));
        maxsum[0]=Math.max(maxsum[0],lsum+rsum+root.val);
        return Math.max(lsum,rsum)+root.val;
    }
}