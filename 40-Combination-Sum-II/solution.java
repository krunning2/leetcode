public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(candidates == null) return res;
        Arrays.sort(candidates);
        helper(candidates, target, 0, 0, res, new ArrayList<>());
        return res;
    }
    private void helper(int[] nums, int target, int sum, int pos, List<List<Integer>> res, List<Integer> cur){
        if(sum > target) return;
        if(sum == target){
            res.add(new ArrayList<>(cur));
            return;
        }
        for(int i = pos; i < nums.length; i++){
            if(i != pos && nums[i - 1] == nums[i]){
                continue;
            }
            sum += nums[i];
            cur.add(nums[i]);
            helper(nums, target, sum, i + 1, res, cur);
            sum -= nums[i];
            cur.remove(cur.size() - 1);
            // while(i < nums.length - 1 && nums[i] == nums[i + 1]){
            //     i++;
            // }
        }
    }
}