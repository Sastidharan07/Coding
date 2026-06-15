//Question : https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/description/
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

    static class NodeRef {
        ListNode node;
    }

    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) {
            return null;
        }

        NodeRef ref = new NodeRef();
        ref.node = head;

        delet(ref, head);

        return ref.node;
    }

    private void delet(NodeRef head, ListNode h) {

        if (h == null || h.next == null) {
            head.node = head.node.next;
        } else {
            NodeRef nextRef = new NodeRef();
            nextRef.node = head.node.next;

            delet(nextRef, h.next.next);
            head.node.next = nextRef.node;
        }
    }
}
