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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode temp = head ;
        ListNode prev = null;

        while(temp != null){
            ListNode dup = temp.next;
            while(dup != null && dup.val == temp.val) dup = dup.next;

            if(dup != temp.next ) {
                if(prev != null ) prev.next = dup;
                else head = dup;
            }else prev = temp;
            temp = dup;
        }
        return head;   
    }
}