public class Solution {
    public boolean search(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;
        while(s + 1 < e){
            int m = s - (s - e) / 2;
            if(nums[m] == target) return true;
            if(nums[m] > nums[s]){
                if(nums[m] >= target && target >= nums[s]){
                    e = m;
                }else{
                    s = m;
                }
            }else if(nums[m] < nums[s]){
                if(nums[m] <= target && target <= nums[e]){
                    s = m;
                }else{
                    e = m;
                }
            }else{
                s++;
            }
        }
        return nums[s] == target || nums[e] == target;
    }
}