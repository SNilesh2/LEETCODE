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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        int maxDepth = findMaxDepth(root);
        return findLca(root,maxDepth,1);
    }

    public static TreeNode findLca(TreeNode root,int maxDepth,int depth)
    {
        if(root==null)
        {
            return null;
        }

        if(depth==maxDepth)
        {
            return root;
        }

        TreeNode left = findLca(root.left,maxDepth,depth+1);

        TreeNode right = findLca(root.right,maxDepth,depth+1);

        if(left!=null && right!=null)
        {
            return root;
        }

        if(left==null)
        {
            return right;
        }

        return left;
    }
    public static int findMaxDepth(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }

        int left = findMaxDepth(root.left);

        int right = findMaxDepth(root.right);

        return Math.max(left,right) + 1;
    }
}