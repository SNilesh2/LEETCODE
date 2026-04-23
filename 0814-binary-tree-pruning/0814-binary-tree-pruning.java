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
    public TreeNode pruneTree(TreeNode root) {
        boolean removeRoot = removeNodes(root);

        if(removeRoot==false)
        {
            root=null;
        }

        return root;
    }
    public boolean removeNodes(TreeNode root)
    {
        if(root==null)
        {
            return false;
        }

        if(root.left==null && root.right==null)
        {
            if(root.val==0)
            {
                return false;
            }
            else
            {
                return true;
            }
        }

        boolean left = removeNodes(root.left);

        if(left==false)
        {
            root.left = null;
        }

        boolean right = removeNodes(root.right);

        if(right==false)
        {
            root.right = null;  
        }

        return left || right || root.val==1 ;
    }
}