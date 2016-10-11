public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums == null || nums.length < 2 || t < 0 || k < 1) return false;
        TreeSet<Integer> set = new TreeSet<>();
        for(int i = 0; i < nums.length; i++){
            int n = nums[i];
            Integer ceiling = set.ceiling(n);
            Integer floor = set.floor(n);
            if(ceiling != null && ceiling - n <= t || floor != null && n <= t + floor){
                return true;
            }
            set.add(n);
            if(i >= k){
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}