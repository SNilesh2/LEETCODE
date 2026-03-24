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
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        int level = 0;

        while(!q.isEmpty())
        {
            int size = q.size();
            List<TreeNode> currentLevel = new ArrayList<>();

            for(int i=0;i<size;i++)
            {
                TreeNode poped = q.poll();
                currentLevel.add(poped);

                if(poped.left!=null)
                {
                    q.add(poped.left);
                }
                if(poped.right!=null)
                {
                    q.add(poped.right);
                }
            }

            if(level%2==1)
            {
                int left = 0;
                int right = currentLevel.size()-1;

                while(left<right)
                {
                    int temp = currentLevel.get(left).val;
                    currentLevel.get(left).val = currentLevel.get(right).val;
                    currentLevel.get(right).val = temp;

                    left++;
                    right--;
                }
            }
            level++;
        }
        return root;
    }
}