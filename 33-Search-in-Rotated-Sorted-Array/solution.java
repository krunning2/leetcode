public class Solution {
    public int search(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;
        while(s + 1< e){
            int m = s - (s - e) / 2;
            if(nums[m] == target){
                return m;
            }
            if(nums[m] > nums[s]){
                if(nums[m] >= target && nums[s] <= target){
                    e = m;
                }else{
                    s = m;
                }
            }else{
                if(nums[m] <= target && target <= nums[e]){
                    s = m;
                }else{
                    e = m;
                }
            }
        }
        if(nums[s] == target) return s;
        if(nums[e] == target) return e;
        return -1;
    }
}