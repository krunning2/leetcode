public class Solution {
    public int combinationSum4(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, target, 0, res, new ArrayList<>(), 0);
        return res.size();
    }
    private void helper(int[] nums, int target, int pos, List<List<Integer>> res, List<Integer> cur, int sum){
        for(int i = pos; i < nums.length; i++){
            sum += nums[i];
            cur.add(nums[i]);
            if(sum <= target)  res.add(new ArrayList(cur));
            helper(nums, target, i, res, cur, sum);
            sum -= nums[i];
            cur.remove(cur.size() - 1);
        }
    }
}