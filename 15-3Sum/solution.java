public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return res;
        }
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            int cur = nums[i];
            int start = i + 1, end = nums.length - 1;
            while(start < end){
                if(nums[start] + nums[end] + cur == 0){
                    res.add(Arrays.asList(new Integer[]{cur, nums[start], nums[end]}));
                    start ++;
                    end --;
                    while(start < end && nums[start] == nums[start - 1]){
                        start++;
                    }
                    while(start < end && nums[end] == nums[end + 1]){
                        end --;
                    }
                }else if(nums[start] + nums[end] + cur > 0){
                    end--;
                }else{
                    start++;
                }
            }
            while(i < nums.length - 3 && nums[i] == nums[i + 1]){
                i++;
            }
        }
        return res;
    }
}