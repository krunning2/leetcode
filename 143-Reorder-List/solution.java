/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode mid = getMid(head);
        ListNode next = mid.next;
        mid.next = null;
        ListNode newHead = reverse(next);
        boolean flag = true;
        while(head != null && newHead != null){
            if(flag){
                ListNode tmp = head.next;
                head.next = newHead;
                head = tmp;
            }else{
                ListNode tmp = newHead.next;
                newHead.next = head;
                newHead = tmp;
            }
            flag = !flag;
        }
    }
    
    private ListNode reverse(ListNode head){
        ListNode pre = null, cur = head;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
    
    private ListNode getMid(ListNode head){
        ListNode fast = head, slow = head;
        while(true){
            fast = fast.next;
            if(fast == null) break;
            fast = fast.next;
            if(fast == null) break;
            slow = slow.next;
        }
        return slow;
    }
}