public class Solution {
    public int removeElement(int[] nums, int val) {
        int start = 0, p = 0;
        while(p < nums.length){
            if(nums[p] == val){
                p++;
            }else{
                nums[start++] = nums[p++];
            }
        }
        return start;
    }
}