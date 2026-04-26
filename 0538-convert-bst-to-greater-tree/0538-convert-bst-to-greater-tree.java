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
    public TreeNode convertBST(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();

        inOrder(root,list);

        int sum = 0;
        for(int i=list.size()-1;i>=0;i--)
        {
            list.get(i).val = list.get(i).val + sum;
            sum = list.get(i).val ;
        }
        return root;
    }
    public static void inOrder(TreeNode root,List<TreeNode> list)
    {
        if(root==null)
        {
            return;
        }

        inOrder(root.left,list);

        list.add(root);

        inOrder(root.right,list);
    }
}