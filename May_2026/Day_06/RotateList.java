//Question : https://leetcode.com/problems/rotate-list/description/
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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode te=head;
        ArrayList<Integer> a=new ArrayList<>();
        while(te!=null){
            
            a.add(te.val);
            te=te.next;
            
        }
        int l=a.size();
        k=k%l;
        ListNode b=new ListNode(-1);
        ListNode c=b;
        for(int i=0;i<l;i++){
            int g=a.get((i-k+l)%l);
            c.next=new ListNode(g);
            c=c.next;
        }
        return b.next;
    }
}