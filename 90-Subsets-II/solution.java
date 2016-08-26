public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        DFS(nums, 0, new ArrayList<>(), res);
        return res;
    }
    private void DFS(int[] nums, int pos, List<Integer> cur, List<List<Integer>> res){
        res.add(new ArrayList<>(cur));
        for(int i = pos; i < nums.length; i++){
            if(i != pos && nums[i] == nums[i - 1]) continue;
            cur.add(nums[i]);
            DFS(nums, i + 1, cur, res);
            cur.remove(cur.size() - 1);
        }
    }
}