/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode plusOne(ListNode head) {
        int carry = helper(head, 1);
        if(carry != 0){
            ListNode newHead = new ListNode(carry);
            newHead.next = head;
            return newHead;
        }
        return head;
    }
    
    private int helper(ListNode node, int carry){
        if(node == null) return carry;
        carry = helper(node.next, carry);
        node.val = node.val + carry;
        carry = node.val / 10;
        node.val = node.val % 10;
        return carry;
    }
    
}