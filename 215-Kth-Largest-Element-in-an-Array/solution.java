public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || k <= 0) return Integer.MIN_VALUE;
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(q.size() < k){
                q.offer(nums[i]);
            }else if(q.peek() < nums[i]){
                q.poll();
                q.offer(nums[i]);
            }
        }
        return q.peek();
    }
}