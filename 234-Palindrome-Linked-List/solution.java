/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        ListNode fast = head;
        ListNode slow = head;
        Stack<Integer> stack = new Stack<Integer>();
        while(true){
            fast = fast.next;
            if(fast == null) break;
            fast = fast.next;
            if(fast == null) break;
            stack.push(slow.val);
            slow = slow.next;
        }
        ListNode p = slow.next;
        while(p != null){
            if(stack.pop() != p.val) return false;
            p = p.next;
        }
        return true;
    }
    private ListNode reverse(ListNode head){
        ListNode p1 = null;
        ListNode p2 = head;
        while(p2 != null){
            ListNode tmp = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = tmp;
        }
        return p1;
    }
}