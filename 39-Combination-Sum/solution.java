public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return res;
        DFS(candidates, target, 0, 0, res, new ArrayList<>());
        return res;
    }
    private void DFS(int[] candidates, int target, int pos, int sum, List<List<Integer>> res, List<Integer> cur){
        if(sum > target){
            return;
        }
        if(sum == target){
            res.add(new ArrayList<>(cur));
            return ;
        }
        for(int i = pos; i < candidates.length; i++){
            cur.add(candidates[i]);
            DFS(candidates, target, i, sum + candidates[i], res, cur);
            cur.remove(cur.size() - 1);
        }
    }
}