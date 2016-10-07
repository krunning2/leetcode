public class Solution {
    public int removeDuplicates(int[] nums) {
        int start = 0;
        int p = 0;
        while(p < nums.length){
            if(p < nums.length - 1 && nums[p] == nums[p + 1]){
                int val = nums[p];
                while(p < nums.length && val == nums[p]){
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