public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length < 3) return 0;
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int res = 0;
        for(int i = 0; i < nums.length - 2; i++){
            int cur = nums[i];
            int start = i + 1;
            int end = nums.length - 1;
            while(start < end){
                if(nums[start] + nums[end] + cur == target){
                    return target;
                }else{
                    if(Math.abs(nums[start] + nums[end] + cur - target) < diff){
                        res = nums[start] + nums[end] + cur;
                        diff = Math.abs(nums[start] + nums[end] + cur - target);
                    }
                    if(nums[start] + nums[end] + cur > target){
                        end --;
                    }else{
                        start ++;
                    }
                }
            }
        }
        return res;
    }
}