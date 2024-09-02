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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null)
        {
            root=new TreeNode(val);
            return root;
        }
        return bst(root,val);
    }
    public static TreeNode bst(TreeNode root,int val)
    {
        if(root==null)
        {
            TreeNode nn=new TreeNode(val);
            return nn;
        }
        if(root.val<val)
        {
            root.right=bst(root.right,val);
        }
        else if(root.val>val)
        {
            root.left=bst(root.left,val);
        }
        return root;
    }
}