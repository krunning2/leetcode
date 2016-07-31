/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, RandomListNode> map = new HashMap();
        RandomListNode p = head;
        //copy nodes
        while(p != null){
            RandomListNode next = p.next;
            p.next = new RandomListNode(p.val);
            p.next.next = next;
            p = next;
        }
        // copy random pointers
        p = head;
        while(p != null){
            if(p.random != null){
                p.next.randomp = p.random.next;
            }
            p = p.next.next;
        }
        // decouple
        p = head;
        RandomListNode newHead = p.next;
        while(p != null && p.next != null){
            RandomListNode next = p.next;
            p.next = p.next.next;
            p = next;
        }
        return newHead;
    }
}