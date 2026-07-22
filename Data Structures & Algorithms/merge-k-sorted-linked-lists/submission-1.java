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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) {
            return null;
        }
        ArrayList<ListNode> convinence = new ArrayList<>();
        for (ListNode node : lists) {
            if (node != null) {
                convinence.add(node);
            }
        }
        ListNode output = new ListNode();
        ListNode tail = output;
        while (!convinence.isEmpty()) {
            int smallest = Integer.MAX_VALUE;
            int pos = -1;
            for (int i = 0; i < convinence.size(); i++) {
                ListNode x = convinence.get(i);
                if (x.val < smallest) {
                    smallest = x.val;
                    pos = i;
                }
            }
            ListNode temp = convinence.get(pos);
            if (temp.next == null) {
                convinence.remove(pos);
            } else {
                convinence.set(pos, temp.next);
            }
            tail.next = new ListNode(temp.val);
            tail = tail.next;
        }
        return output.next;
    }
}
