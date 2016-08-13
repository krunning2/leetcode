public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<int[]>();
        if(nums1 == null || nums2 == null || k <= 0) return res;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> (a[0] + a[1] - b[0] - b[1]));
        for(int i = 0; i < Math.min(k, nums1.length); i++){
            queue.offer(new int[]{nums1[i], nums2[0], 0});
        }
        for(int i = 0; i < k; i++){
            int[] cur = queue.poll();
            res.add(new int[] {cur[0], cur[1]});
            if(cur[2] < nums2.length - 1){
                queue.offer(new int[] {cur[0], nums2[cur[2] + 1], cur[2] + 1});
            }
        }
        return res;
    }
}