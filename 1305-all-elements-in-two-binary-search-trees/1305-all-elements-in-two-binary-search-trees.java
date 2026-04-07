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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        inOrder(root1,list1);
        inOrder(root2,list2);

        int left=0,right=0;
        int length1 = list1.size();
        int length2 = list2.size();

        while(left<length1 && right<length2)
        {
            if(list1.get(left) < list2.get(right))
            {
                result.add(list1.get(left));
                left++;
            }
            else
            {
                result.add(list2.get(right));
                right++;
            }
        }

        while(left < length1)
        {
            result.add(list1.get(left));
            left++;
        }

        while(right < length2)
        {
            result.add(list2.get(right));
            right++;
        }

        return result;
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