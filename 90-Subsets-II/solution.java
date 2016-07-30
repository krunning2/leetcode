public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        helper(res, nums, 0, new ArrayList());
        return res;
    }
    private void helper(List<List<Integer>> res, int[] nums, int pos, List<Integer> cur){
        res.add(new ArrayList<Integer>(cur));
        for(int i = pos; i < nums.length; i++){
            if(i != pos && nums[i] == nums[i - 1]){
                continue;
            }
            cur.add(nums[i]);
            helper(res, nums, i + 1, cur);
            cur.remove(cur.size() - 1);
        }
    }
}