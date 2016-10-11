public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        int next = nums[0], pre = nums[0];
        for(int i = 0; i < nums.length; i++){
            if(next == nums[i]){
                next ++;
            }else{
                res.add(print(pre, nums[i - 1]));
                pre = nums[i];
                next = nums[i] + 1;
            }
        }
        res.add(print(pre, nums[nums.length - 1]));
        return res;
    }
    private String print(int a, int b){
        return a == b ? String.valueOf(a) : a + "->" + b;
    }
}