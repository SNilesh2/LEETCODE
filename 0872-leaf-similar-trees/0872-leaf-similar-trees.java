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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        findLeaves(root1,list1);
        System.out.println("root1 completed");
        System.out.println(list1);
        findLeaves(root2,list2);
        System.out.println("root2 completed");
        System.out.println(list2);

        if(list1.size() != list2.size())
        {
            return false;
        }

        System.out.println("before loop it is false");
        for(int i=0;i<list1.size();i++)
        {
            if(!list1.get(i).equals(list2.get(i)))
            {
                System.out.println(list1.get(i) + " " + list2.get(i));
                return false;
            }
        }
        return true;
    }
    public static void findLeaves(TreeNode root,List<Integer> list)
    {
        if(root==null)
        {
            return;
        }
        if(root.left==null && root.right==null)
        {
            list.add(root.val);
            return;
        }

        findLeaves(root.left,list);
        findLeaves(root.right,list);
    }
}
