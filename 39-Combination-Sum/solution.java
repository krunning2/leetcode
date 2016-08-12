public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new Array<>();
        helper(candidates, target, res, new ArrayList<>(), 0);
        return res;
    }
    private void helper(int[] nums, int target, List<List<Integer>> res, List<Integer> cur, int sum){
        if(sum > target) return;
        if(sum == target){
            res.add(new ArrayList(cur));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            cur.add(nums[i]);
            helper(nums, target, res, cur, sum);
            sum -= nums[i];
            cur.remove(cur.size() - 1);
        }
    }
}