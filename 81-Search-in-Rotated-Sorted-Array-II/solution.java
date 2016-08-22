public class Solution {
    public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return false;
        }
        int start = 0;
        int end = nums.length - 1;
        while(start + 1 < end){
            int mid = start - (start - end) / 2;
            if(nums[mid] == target){
                return true;
            }else{
                if(nums[mid] > nums[start]){
                    if(target >= nums[start] && target <= nums[mid]){
                        end = mid;
                    }else{
                        start = mid;
                    }
                }else if(nums[mid] < nums[start]){
                    if(target >= nums[mid] && target <= nums[end]){
                        start = mid;
                    }else{
                        end = mid;
                    }
                }else{
                    start++;
                }
            }
        }
        return (nums[start] == target) || (nums[end] == target);
    }
}