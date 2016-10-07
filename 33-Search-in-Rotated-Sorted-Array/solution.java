public class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return 0;
        int start = 0;
        int end = nums.length - 1;
        while(start + 1 < end){
            int mid = start - (start - end) / 2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] >= nums[start]){
                if(target <= nums[mid] && target >= nums[start]){
                    end = mid;
                }else{
                    start = mid;
                }
            }else{
                if(target >= nums[mid] && nums[end] >= target){
                    start = mid;
                }else{
                    end = mid;
                }
            }
        }
        if(nums[end] == target) return end; 
        if(nums[start] == target) return start;
        return -1;
    }
}