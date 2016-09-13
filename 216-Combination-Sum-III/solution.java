public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>> ();
        helper(res, new ArrayList<>(), k, 0, n, 1);
        return res;
    }
    private void helper(List<List<Integer>> res, List<Integer> cur, int k, int sum, int target, int pos){
        if(k == cur.size() && target == sum){
            res.add(new ArrayList<>(cur));
            return;
        }
        if(cur.size() >= k) return;
        for(int i = pos; i <= 9; i++){
            sum += i;
            cur.add(i);
            helper(res, cur, k, sum, target, i + 1);
            sum-=i;
            cur.remove(cur.size() - 1);
        }
    }
}