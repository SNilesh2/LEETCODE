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
    public int averageOfSubtree(TreeNode root) {
        int[] ans = new int[1];
        findCount(root,ans);
        return ans[0];
    }

    public static int[] findCount(TreeNode root,int[] ans)
    {

        //0th ind -> sum
        //1st ind -> no of nodes in a subtree
        //2nd ind -> count (final answer)
        if(root==null)
        {
            int[] temp = new int[2];
            temp[0]=0;
            temp[1]=0;
            return temp;
        }

        
        int[] left = findCount(root.left,ans); 
    
        int[] right = findCount(root.right,ans); 

        int sum = left[0] + right[0] + root.val;
        int count = (left[1] + right[1]) + 1;
        int avg = sum/count;

        int[] finalArr = new int[2];
        finalArr[0] = sum;
        finalArr[1] = count;
        if(avg==root.val)
        {
            ans[0]++;
        }
        return finalArr;
    }
}