public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        res.add(new ArrayList<Integer>());
        helper(nums, 0, res, new ArrayList());
        return res;
    }
    private void helper(int[] nums, int pos, List<List<Integer>> res, List<Integer> cur){
        if(cur.size() > 0){
            res.add(new ArrayList(cur));
        }
        for(int i = pos; i < nums.length; i++){
            cur.add(nums[i]);
            helper(nums, i + 1, res, cur);
            cur.remove(cur.size() - 1);
        }
    }
}