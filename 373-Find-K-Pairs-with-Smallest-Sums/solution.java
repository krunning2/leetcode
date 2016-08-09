public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<int[]> ();
        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0 || k == 0) return res;
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(k, (a, b) -> (a[0] + a[1] - b[0] - b[1]));
        for(int i = 0; i < nums1.length && i < k; i++){
            queue.offer(new int[]{nums1[i], nums2[0], 0});
        }
        while(k > 0 && !queue.isEmpty()){
            k--;
            int[] cur = queue.poll();
            res.add(new int[] {cur[0], cur[1]});
            if(cur[2] == nums2.length - 1) continue;
            queue.offer(new int[]{cur[0], nums2[cur[2] + 1], cur[2] + 1});
        }
        return res;
    }
}