public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null) return res;
        Arrays.sort(nums);
        DFS(nums, new ArrayList<>(), res, new boolean[nums.length]);
        return res;
    }
    private void DFS(int[] nums, List<Integer> cur, List<List<Integer>> res, boolean[] visited){
        if(cur.size() == nums.length){
            res.add(new ArrayList<>(cur));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(visited[i] || i != 0 && nums[i - 1] == nums[i] && !visited[i - 1]) continue;
            visited[i] = true;
            cur.add(nums[i]);
            DFS(nums, cur, res, visited);
            visited[i] = false;
            cur.remove(cur.size() - 1);
        }
    }
}