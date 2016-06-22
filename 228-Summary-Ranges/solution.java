public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<String>();
        if(nums == null || nums.length == 0) return res;
        int next = nums[0];
        int pre = nums[0];
        for(int i = 0; i < nums.length; i++){
            if(next == nums[i]){
                next++;
                continue;
            }
            if(next < nums[i]){
                res.add(print(pre, next - 1));
                pre = nums[i];
                next = nums[i] + 1;
            }
        }
        res.add(print(pre, next - 1));
        return res;
    }
    private String print(int a, int b){
        return a == b ? String.valueOf(a) : a + "->" + b;
    }
}