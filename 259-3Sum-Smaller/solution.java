public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int count;
        for(int i = 0; i < nums.length - 2; i++){
            int start = i + 1;
            int end = nums.length - 1;
            while(start < end){
                if(nums[start] + nums[end] + nums[i] < target){
                    count += end - start;
                    break;
                }else{
                    end--;
                }
            }
        }
        return count;
    }
}