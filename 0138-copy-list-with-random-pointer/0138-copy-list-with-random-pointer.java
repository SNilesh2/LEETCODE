/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node temp = head;
        Node prev = null;
        Node newHead = null;
        HashMap<Node,Node> map = new HashMap<>();


        while(temp!=null)
        {
            Node nn = new Node(temp.val);

            map.put(temp,nn);

            if(prev==null)
            {
                newHead = nn;
            }
            else
            {
                prev.next = nn;
            }

            prev = nn;
            temp = temp.next;
        }

        temp = head;
        while(temp!=null)
        {
            Node node1 = temp;
            Node node2 = temp.random;

            if(node2!=null)
            {
                map.get(node1).random = map.get(node2);
            }
            temp = temp.next;
        }

        return newHead;
    }
}