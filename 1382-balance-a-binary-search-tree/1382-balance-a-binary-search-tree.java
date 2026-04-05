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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root,list);


        return balance(list,0,list.size()-1);
    }

    public static TreeNode balance(List<Integer> list,int low,int high)
    {
        if(low>high)
        {
            return null;
        }

        int mid = low + (high-low)/2;

        TreeNode newNode = new TreeNode(list.get(mid));

        newNode.left = balance(list,low,mid-1);

        newNode.right = balance(list,mid+1,high);

        return newNode;
    }
    public static void inOrder(TreeNode root,List<Integer> list)
    {
        if(root==null)
        {
            return;
        }

        inOrder(root.left,list);

        list.add(root.val);

        inOrder(root.right,list);
    }
}