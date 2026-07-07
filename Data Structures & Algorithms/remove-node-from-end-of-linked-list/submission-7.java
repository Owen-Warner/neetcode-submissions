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
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 1;
        ListNode clone = head;
        while(clone.next != null){
            len++;
            clone = clone.next;
        }
        int removePos = len - n;
        if(removePos == 0){
            return head.next;
        }
        else{
            clone = head;
            while(removePos != 1){
                clone = clone.next;
                removePos--;
            }
            clone.next = clone.next.next;
            return head;
        }
    }
}
