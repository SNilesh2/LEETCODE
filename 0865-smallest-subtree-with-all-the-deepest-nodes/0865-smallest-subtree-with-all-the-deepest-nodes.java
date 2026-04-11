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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        int maxDepth = findMaxDepth(root);
        return findSubtree(root,1,maxDepth);
    }
    public static TreeNode findSubtree(TreeNode root,int depth,int maxDepth)
    {
        if(root==null)
        {
            return null;
        }

        if(depth==maxDepth)
        {
            return root;
        }

        TreeNode left = findSubtree(root.left,depth+1,maxDepth);

        TreeNode right = findSubtree(root.right,depth+1,maxDepth);

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