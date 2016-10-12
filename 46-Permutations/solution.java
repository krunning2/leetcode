public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        DFS(nums, new boolean[nums.length], res, new ArrayList<>());
        return res;
    }
    
    private void DFS(int[] nums, boolean[] visited, List<List<Integer>> res, List<Integer> cur){
        if(cur.size() == nums.length){
            res.add(new ArrayList<>(cur));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(visited[i]){
               continue; 
            }
            visited[i] = true;
            cur.add(nums[i]);
            DFS(nums, visited, res, cur);
            visited[i] = false;
            cur.remove(cur.size() - 1);
        }
    }
}