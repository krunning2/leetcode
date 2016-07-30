public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(res, nums, 0, new ArrayList(), new boolean[nums.length]);
        return res;
    }
    private void helper(List<List<Integer>> res, int[] nums, int pos, List<Integer> cur, boolean[] visited){
        res.add(new ArrayList<Integer>(cur));
        for(int i = pos; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i - 1] && !visited[i]){
                continue;
            }
            visited[i] = true;
            cur.add(nums[i]);
            helper(res, nums, i + 1, cur);
            cur.remove(cur.size() - 1);
            visited[i] = false;
        }
    }
}