public class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null) return res;
        Arrays.sort(nums);
        helper(nums, target, 0, 0, res, new ArrayList<>(), new boolean[nums.length]);
        return res;
    }
    private void helper(int[] nums, int target, int sum, int pos, List<List<Integer>> res, List<Integer> cur, boolean[] visited){
        if(sum > target) return;
        if(sum == target){
            res.add(new ArrayList<>(cur));
            return;
        }
        for(int i = pos; i < nums.length; i++){
            if(i != 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;
            visited[i - 1] = true;
            sum += nums[i];
            cur.add(nums[i]);
            helper(nums, target, sum, i + 1, res, cur, visited);
            sum -= nums[i];
            cur.remove(cur.size() - 1);
            visited[i - 1] = false;
        }
    }
}