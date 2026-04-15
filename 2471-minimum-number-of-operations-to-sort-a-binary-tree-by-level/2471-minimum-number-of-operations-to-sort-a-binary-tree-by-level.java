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
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        int result = 0;
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();

            List<Integer> list = new ArrayList<>();
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < size; i++) {
                TreeNode polled = q.poll();

                if (polled.left != null) {
                    q.add(polled.left);
                    list.add(polled.left.val);
                }

                if (polled.right != null) {
                    q.add(polled.right);
                    list.add(polled.right.val);
                }
            }
            List<Integer> sorted = new ArrayList<>(list);
            Collections.sort(sorted);

            for (int i = 0; i < list.size(); i++) {
                map.put(list.get(i), i);
            }

            boolean[] visited = new boolean[list.size()];

            for (int i = 0; i < list.size(); i++) {
                if (visited[i] || map.get(sorted.get(i)) == i)
                    continue;

                int cycleSize = 0;
                int j = i;

                while (!visited[j]) {
                    visited[j] = true;
                    j = map.get(sorted.get(j));
                    cycleSize++;
                }

                if (cycleSize > 1) {
                    result += (cycleSize - 1);
                }
            }
        }

        return result;
    }
}