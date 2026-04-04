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
    public int minDiffInBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root,list);
        int result = Integer.MAX_VALUE;;
        for(int i=1;i<list.size();i++)
        {
            result = Math.min(result,list.get(i)-list.get(i-1));
        }
        return result;
    }

    public static void helper(TreeNode root,List<Integer> list)
    {
        if(root==null)
        {
            return;
        }

        helper(root.left,list);

        list.add(root.val);

        helper(root.right,list);
    }
}