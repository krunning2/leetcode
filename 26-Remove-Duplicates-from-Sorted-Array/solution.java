public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int p = 0;
        int start = 0;
        while(p < nums.length){
            if(p + 1 < nums.length && nums[p] == nums[p + 1]){
                int cur = nums[p];
                while(p < nums.length && cur == nums[p]){
                    p++;
                }
                nums[start++] = cur;
            }else{
                nums[start ++] = nums[p];
                p++;
            }
        }
        return start;
    }
}