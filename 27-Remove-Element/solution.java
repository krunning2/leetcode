public class Solution {
    public int removeElement(int[] nums, int val) {
        int start = 0;
        int p = 0;
        while(p < nums.length){
            if(nums[p] != val){
                nums[start++] = nums[p];
            }
            p++;
        }
        return start;
    }
}