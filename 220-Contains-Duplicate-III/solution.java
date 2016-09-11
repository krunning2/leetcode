public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums == null || nums.length < 2 || t < 0 || k < 1) return false;
        TreeSet<Integer> set = new TreeSet<>();
        for(int i = 0; i < nums.length; i++){
            Integer ceiling = set.ceiling(nums[i]);
            Integer floor = set.floor(nums[i]);
            if(floor != null && nums[i] <= t + floor || ceiling != null && ceiling - nums[i] <= t){
                return true;
            }
            set.add(nums[i]);
            if(i >= k) set.remove(nums[i - k]);
        }
        return false;
    }
}