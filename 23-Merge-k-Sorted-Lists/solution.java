/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>(){
            public int compare(ListNode l1, ListNode l2){
                return l1.val - l2.val;
            }
        });
        ListNode head = new ListNode();
        ListNode cur = head;
        for(ListNode node : lists){
            if(node != null){
                queue.offer(node);
            }
        }
        while(!queue.isEmpty()){
            cur.next = queue.poll();
            if(cur.next.next != null){
                queue.offer(cur.next.next);
            }
            cur = cur.next;
        }
        return head.next;
    }
}