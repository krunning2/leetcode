/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode p = head;
        ListNode post = head.next;
        while(post != null){
            if(post.val == p.val){
                int val = p.val;
                while(post != null &&post.val == val){
                    post = post.next;
                }
                pre.next = post;
                p = post;
                if(post != null){
                    post = post.next;
                }
            }else{
                pre = p;
                p = post;
                post = post.next;
            }
        }
        return dummy.next;
    }
}