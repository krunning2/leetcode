public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        DFS(nums, new boolean[nums.length], new ArrayList<>(), res);
        return res;
    }
    private void DFS(int[] nums, boolean[] visited, List<Integer> list, List<List<Integer>> res){
        if(list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(visited[i] || i != 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;
            list.add(nums[i]);
            visited[i] = true;
            DFS(nums, visited, list, res);
            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }
}