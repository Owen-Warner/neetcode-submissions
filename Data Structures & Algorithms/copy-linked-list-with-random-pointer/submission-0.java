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
        Map<Node, Node> clones = new HashMap<>();
        Node cur = head;
        while(cur != null){
            clones.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while(cur != null){
            clones.get(cur).next = clones.get(cur.next);
            clones.get(cur).random = clones.get(cur.random);
            cur = cur.next;
        }
        return clones.get(head);
    }
}
