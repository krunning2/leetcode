public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res  = new ArrayList<List<Integer>> ();
        helper(n, k, res, new ArrayList(), 1, 0);
        return res;
    }
    private void helper(int n, int k, List<List<Integer>> res, List<Integer> cur, int pos, int sum){
        if(cur.size() == k && sum == n){
            res.add(new ArrayList<>(cur));
            return;
        }
        if(cur.size() >= k) return;
        for(int i = pos; i <= 9; i ++){
            cur.add(i);
            helper(n, k, res, cur, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}