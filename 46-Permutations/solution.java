public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null) return res;
        DFS(nums, new ArrayList<>(), res, new boolean[nums.length]);
        return res;
    }
    private void DFS(int[] nums, List<Integer> cur, List<List<Integer>> res, boolean[] visited){
        if(cur.size() == nums.length){
            res.add(new ArrayList<>(cur));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(!visited[i]){
                visited[i] = true;
                cur.add(nums[i]);
                DFS(nums, cur, res, visited);
                visited[i] = false;
                cur.remove(cur.size() - 1);
            }
        }
    }
}