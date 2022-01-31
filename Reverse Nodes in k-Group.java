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
    public ListNode th = null;
    public ListNode tt = null;
    public ListNode oh = null;
    public ListNode ot = null;
    
    public void addFirst(ListNode node){
        if(th == null){
            th = node;
            tt = node;
        }else{
            node.next = th;
            th = node;
        }
    }
    
    public int getLength(ListNode head){
        ListNode temp = head;
        int count = 0;
        while(temp!=null){
            count++;
            temp = temp.next;
        }
        return count;
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        int length = getLength(head);
        ListNode curr = head;
        while(length >= k){
            int i=0;
            while(i<k){
                ListNode frwd = curr.next;
                curr.next = null;
                addFirst(curr);
                curr = frwd;
                i++;
            }
            if(oh == null){
                oh = th;
                ot = tt;
                th = null;
                tt = null;
            }else{
                ot.next = th;
                ot = tt;
                th = null;
                tt = null;
            }
            length -= k;
        }
        if(length >0){
            ot.next = curr;
        }
        return oh;
    }
}
