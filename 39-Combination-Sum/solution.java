public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        helper(candidates, target, 0, 0, new ArrayList<>(), res);
        return res;
    }
    private void helper(int[] candidates, int target, int pos, int sum, List<Integer> cur, List<List<Integer>> res){
        if(target == sum){
            res.add(new ArrayList<>(cur));
            return;
        }
        if(target < sum){
            return;
        }
        for(int i = pos; i < candidates.length; i++){
            sum += candidates[i];
            cur.add(candidates[i]);
            helper(candidates, target, i, sum, cur, res);
            sum -= candidates[i];
            cur.remove(cur.size() - 1);
        }
    }
}