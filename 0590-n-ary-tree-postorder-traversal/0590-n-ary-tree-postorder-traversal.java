/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
*/

class Solution {
    public List<Integer> postorder(Node root) {
        LinkedList<Integer> res = new LinkedList<>();

        if(root==null)
        {
            return res;
        }
        Stack<Node> st= new Stack<>();

        st.push(root);

        while(!st.isEmpty())
        {
            Node curr = st.pop();

            res.addFirst(curr.val);

            for(Node temp : curr.children)
            {
                st.push(temp);
            }
        }
        return res;
    }
}