public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(n <= 1) return res;
        List<Integer> set = new ArrayList<>();
        for(int i = 2; i < n / 2 + 1; i++){
            if(n % i == 0) set.add(i);
        }
        
        helper(set, res, new ArrayList<>(), 0, n, 1L);
        return res;
    }
    private void helper(List<Integer> set, List<List<Integer>> res, List<Integer> cur, int pos, int n, long fac){
        if(fac == n){
            res.add(new ArrayList<>(cur));
            return;
        }
        if(fac > n) return;
        for(int i = pos; i < set.size(); i++){
            cur.add(set.get(i));
            fac *= set.get(i);
            helper(set, res, cur, i, n, fac);
            cur.remove(cur.size() - 1);
            fac /= set.get(i);
        }
    }
}