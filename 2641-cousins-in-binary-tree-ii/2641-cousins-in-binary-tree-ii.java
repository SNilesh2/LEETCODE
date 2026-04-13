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
    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        List<Integer> list = new ArrayList<>();

        while(!q.isEmpty())
        {
            int size = q.size();

            int sum = 0;
            for(int i=0;i<size;i++)
            {
                TreeNode polled = q.poll();

                sum = sum + polled.val;

                if(polled.left!=null)
                {
                    q.add(polled.left);
                }

                if(polled.right!=null)
                {
                    q.add(polled.right);
                }
            }

            list.add(sum);
        }

        root.val = 0;

        Queue<TreeNode> q2 = new LinkedList<>();

        q2.add(root);

        int level = 1;
        while(!q2.isEmpty() && level<list.size())
        {
            int size = q2.size();

            
            for(int i=0;i<size;i++)
            {
                int currentSum = 0;
                TreeNode polled = q2.poll();

                TreeNode left = null;
                TreeNode right = null;
                if(polled.left!=null)
                {
                    left = polled.left;
                    currentSum = currentSum + left.val;
                }

                if(polled.right!=null)
                {
                    right = polled.right;
                    currentSum = currentSum + right.val;
                }

                System.out.println(currentSum);
                if(left!=null)
                {
                    left.val = list.get(level) - currentSum;
                    q2.add(left);
                }

                if(right!=null)
                {
                    right.val = list.get(level) - currentSum;
                    q2.add(right);
                }
            }
            level++;
        }

        return root;
    }
}