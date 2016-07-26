public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if(nums == null || nums.length <= 0) return res;
        int s = 0;
        int e = nums.length - 1;
        while(s + 1 < e){
            int mid = s - (s - e) / 2;
            if(nums[mid] >= target){
                e = mid;
            }else{
                s = mid;
            }
        }
        if(nums[s] == target){
            res[0] = s;
        }else if(nums[e] == target){
            res[0] = e;
        }else{
            return res;
        }
        
        s = res[0];
        e = nums.length - 1;
        while(s + 1 < e){
            int mid = s - (s - e) / 2;
            if(nums[mid] > target){
                e = mid;
            }else{
                s = mid;
            }
        }
        if(nums[e] == target){
            res[1] = e;
        }else if(nums[s] == target){
            res[1] = s;
        }
        return res;
    }
}