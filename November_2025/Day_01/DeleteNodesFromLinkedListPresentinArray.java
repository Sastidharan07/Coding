//Question : https://leetcode.com/problems/delete-nodes-from-linked-list-present-in-array/description/
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
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> hs = new HashSet<>();
        for(int num : nums) hs.add(num);

        ListNode cur = head, prev = null;
        while(cur != null) {
            if(hs.contains(cur.val)) {
                if(cur == head) 
                    head=head.next;
                else
                    prev.next = cur.next;
            } else {
                prev = cur;
            }
            cur = cur.next;
        }
        return head;
    }
}