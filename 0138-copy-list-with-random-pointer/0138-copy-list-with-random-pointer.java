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

        //inserting new nodes in the middle
        while(temp!=null)
        {
            Node nn = new Node(temp.val);

            nn.next = temp.next;
            temp.next = nn;

            temp = temp.next.next;
        }

        //changing the random pointers of the new list
        temp = head;
        while(temp!=null)
        {
            Node randomNode= temp.random;

            if(randomNode!=null)
            {
                temp.next.random = randomNode.next;
            }

            temp = temp.next.next;
        }

        //changing the next pointers for both the lists
        temp = head;
        Node dummy = new Node(-1);
        Node res = dummy;
        while(temp!=null)
        {
            Node nextNode = temp.next.next;
            res.next = temp.next;
            if(nextNode!=null)
            {
                temp.next.next = nextNode.next;
            }
            temp.next = nextNode;

            res = res.next;
            temp = nextNode;
        }

        return dummy.next;
    }
}