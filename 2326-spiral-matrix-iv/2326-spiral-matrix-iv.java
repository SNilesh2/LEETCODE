/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] result=new int[m][n];

        for(int[] arr : result)
        {
            Arrays.fill(arr,-1);
        }
        
        ListNode temp=head;

        int left=0;
        int right=n-1;
        int top=0;
        int bottom=m-1;
        while(temp!=null)
        {
            //left to right
            for(int i=left;i<=right;i++)
            {
                result[top][i]=temp.val;
                temp=temp.next;
                if(temp==null)
                {
                    return result;
                }
            }

            top++;
            //top to bottom
            for(int i=top;i<=bottom;i++)
            {
                result[i][right]=temp.val;
                temp=temp.next;
                if(temp==null)
                {
                    return result;
                }
            }            

            right--;
            //right to left
            for(int i=right;i>=left;i--)
            {
                result[bottom][i]=temp.val;
                temp=temp.next;
                if(temp==null)
                {
                    return result;
                }
            }

            bottom--;
            //bottom to top
            for(int i=bottom;i>=top;i--)
            {
                result[i][left]=temp.val;
                temp=temp.next;
                if(temp==null)
                {
                    return result;
                }
            }

            left++;
        }
        return result;
    }
}