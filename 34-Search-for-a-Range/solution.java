public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        int start = 0;
        int end = nums.length - 1;
        while(start + 1< end){
            int mid = start - (start - end) / 2;
            if(nums[mid] >= target){
                end = mid;
            }else{
                start = mid;
            }
        }
        if(nums[start] == target){
            res[0] = start;
        }else if(nums[end] == target){
            res[0] = end;
        }else{
            return res;
        }
        start = res[0];
        end = nums.length - 1;
        while(start + 1< end){
            int mid = start - (start - end) / 2;
            if(nums[mid] > target){
                end = mid;
            } else {
                start = mid;
            }
        }
        if(nums[end] == target){
            res[1] = end;
        }else if(nums[start] == target){
            res[1] = start;
        }
        return res;
    }
}