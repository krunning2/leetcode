public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null) return 0;
        int start = 0;
        int p = 0;
        while(p < nums.length){
            if(p < nums.length - 1 && nums[p] == nums[p + 1]){
                int val = nums[p];
                while(p < nums.length && nums[p] == val){
                    p++;
                }
                nums[start++] = val;
            }else{
                nums[start++] = nums[p++];
            }
        }
        return start;
    }
}