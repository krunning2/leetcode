public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        int next = lower;
        List<String> res = new ArrayList<String>();
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < next){
                continue;
            }
            if(nums[i] == next){
                next ++;
                continue;
            }
            res.add(print(next, nums[i] - 1));
            next = nums[i] + 1;
        }
        if(next <= upper){
            res.add(print(next, upper));
        }
        return res;
    }
    
    private String print(int a, int b){
        return a == b ? String.valueOf(a) : a + "->" + b;   
    }
}