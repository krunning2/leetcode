public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums == null || nums.length < 2 || k < 1 || t < 0) return false;
        TreeSet<Integer> set = new TreeSet<>();
        for(int i = 0; i < nums.length; i++){
            int n = nums[i];
            Integer ceiling = set.ceiling(n);
            Integer floor = set.floor(n);
            //to avoid overflow
            if(floor != null && n <= t + floor || ceiling != null && ceiling - n <= t){
                return true;
            }
            set.add(n);
            if(i >= k) set.remove(nums[i - k]);
        }
        return false;
    }
}