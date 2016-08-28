public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        int next = lower;
        for(int i = 0; i < nums.length; i++){
            // because of duplicate
            if(nums[i] < next){
                continue;
            }else if(nums[i] == next){
                next ++;
            }else{
                res.add(print(next, nums[i] - 1));
                next = nums[i] + 1;
            }
        }
        if(next <= upper) res.add(print(next, upper));
        return res;
    }
    private String print(int a, int b){
        return a == b ? String.valueOf(a) : a + "->" + b;
    }
}