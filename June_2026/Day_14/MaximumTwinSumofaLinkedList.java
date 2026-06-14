//Question : https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/
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
    public int pairSum(ListNode head) {

        // Find 1 st middle of the linked list usin Tortoise ALGO
        ListNode slow = head;
        ListNode fast = head.next;//reason is we r finding first middle so we initializes fast froom head.next

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Split the list into two halves
        ListNode newHead = slow.next;
        slow.next = null;
        // Reverse the second half
        newHead = reverseIterative(newHead);
        int max = Integer.MIN_VALUE;
        ListNode temp = head;
        // Calculate twin sums and find maximum
        while (newHead != null) {
            max = Math.max(max, temp.val + newHead.val);
            temp = temp.next;
            newHead = newHead.next;
        }

        return max;
    }
    ListNode reverseIterative(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next; // store next node
            curr.next = prev;          // reverse link
            prev = curr;               // move prev forward
            curr = next;               // move curr forward
        }

        return prev; 
    }
}
