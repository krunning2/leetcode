public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(nums, new boolean[nums.length], res, new ArrayList());
        return res;
    }
    
    private void helper(int[] nums, boolean[] visited, List<List<Integer>> res, List<Integer> cur){
        if(cur.size() == nums.length){
            res.add(new ArrayList(cur));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(!visited[i]){
                cur.add(nums[i]);
                visited[i] = true;
                helper(nums, visited, res, cur);
                visited[i] = false;
                cur.remove(cur.size() - 1);
            }
        }
    }
}