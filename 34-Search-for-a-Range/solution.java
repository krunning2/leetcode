public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if(nums == null || nums.length == 0) return res;
        int start = 0, end = nums.length - 1;
        while(start + 1 < end){
            int mid = start - (start - end) / 2;
            if(nums[mid] >= target){
                end = mid;
            }else {
                start = mid;
            }
        }
        if(target == nums[start]){
            res[0] = start;
        }else if(target == nums[end]){
            res[0] = end;
        }else{
            return res;
        }
        end = nums.length - 1;
        start = res[0];
        while(start + 1 < end){
            int mid = start - (start - end) / 2;
            if(nums[mid] > target){
                end = mid;
            }else {
                start = mid;
            }
        }
        if(target == nums[end]){
            res[1] = end;
        }else if(target == nums[start]){
            res[1] = start;
        }
        return res;
    }
}