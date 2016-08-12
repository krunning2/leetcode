public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res  = new ArrayList<List<Integer>> ();
        helper(n, k, res, new ArrayList<>(), 1);
        return res;
    }
    private void helper(int n, int k, List<List<Integer>> res, List<Integer> cur, int pos){
        if(cur.size() == k){
            res.add(new ArrayList<>(cur));
            return;
        }
        for(int i = pos; i <= n; i ++){
            cur.add(i);
            helper(n, k, res, cur, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}