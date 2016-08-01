public class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int p = 0;
        swap(nums, 0, nums.length - k - 1);
        swap(nums, nums.length - k, nums.length - 1);
        swap(nums, 0, nums.length - 1);
    }
    private void swap(int[] nums, int s, int e){
        while(s <= e){
            int tmp = nums[s];
            nums[s] = nums[e];
            nums[e] = tmp;
        }
    }
}