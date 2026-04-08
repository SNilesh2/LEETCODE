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
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer, TreeNode> map = new HashMap<>();

        TreeNode parent = null;
        TreeNode child = null;
        for (int[] arr : descriptions) {
            boolean isLeft = (arr[2] == 1) ? true : false;

            //parent
            if (map.containsKey(arr[0])) {
                parent = map.get(arr[0]);
            } else {
                parent = new TreeNode(arr[0]);
                map.put(arr[0], parent);
            }

            //child
            if (map.containsKey(arr[1])) {
                child = map.get(arr[1]);
            } else {
                child = new TreeNode(arr[1]);
                map.put(arr[1], child);
            }

            //left child or right child 
            if (isLeft) {
                parent.left = child;
            } else {
                parent.right = child;
            }
        }

        for(int[] arr : descriptions)
        {
            map.remove(arr[1]);
        }

        List<TreeNode> result = new ArrayList<>(map.values());

        return result.get(0);
    }
}