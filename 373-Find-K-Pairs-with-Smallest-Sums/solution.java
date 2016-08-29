public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> result = new ArrayList<>();
        if(nums1 == null || nums2 == null || nums2.length == 0 || nums1.length == 0){
            return result;
        }
        PriorityQueue<Cell> queue = new PriorityQueue<Cell>(k, (a, b) -> (a.val1 + a.val2 - b.val1 - b.val2));
        for(int i = 0; i < Math.min(k, nums1.length); i++){
            queue.offer(new Cell(nums1[i], nums2[0], 0));
        }
        for(int i = 0; i < Math.min(k, nums1.length * nums2.length); i++){
            Cell cur = queue.poll();
            result.add(new int[] {cur.val1, cur.val2});
            if(cur.index2 < nums2.length - 1){
                queue.offer(new Cell(cur.val1, nums2[cur.index2 + 1], cur.index2 + 1));
            }
        }
        return result;
    }
    class Cell{
        int val1;
        int val2;
        int index2;
        Cell(int val1, int val2, int index2){
            this.val1 = val1;
            this.val2 = val2;
            this.index2 = index2;
        }
    }
}