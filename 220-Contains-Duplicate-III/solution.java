public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums == null || nums.length < 2 ||k < 1 || t < 0) return false;
        Set<Integer> set = new TreeSet<>();
        for(int i = 0; i < nums.length; i++){
            int n = nums[i];
            Integer ceiling = set.ceiling(n);
            Integer floor = set.floor(n);
            if(ceiling != null && n - floor <= t || floor != null && floor - x <= t){
                return true;
            }
            if(i > k) set.remove(nums[i - k]);
        }
        return false;
    }
}