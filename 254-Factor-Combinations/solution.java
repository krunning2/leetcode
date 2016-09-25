public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<Integer> set = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(n <= 1) return res;
        for(int i = 2; i < n; i++){
            if(n % i == 0){
                set.add(i);
            }
        }
        DFS(1, n, 0, set, new ArrayList<>(), res);
        return res;
    }
    private void DFS(long fac, int n, int start, List<Integer> set, List<Integer> cur, List<List<Integer>> res){
        if(fac == n){
            res.add(new ArrayList<Integer>(cur));
        }else if(fac > n){
            return;
        }
        for(int i = start; i < set.size(); i++){
            cur.add(set.get(i));
            DFS(fac * set.get(i), n, i, set, cur, res);
            cur.remove(cur.size() - 1);
        }
    }
}