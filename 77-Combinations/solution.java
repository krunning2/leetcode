public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        DFS(res, new ArrayList<>(), k, 1, n);
        return res;
    }
    private void DFS(List<List<Integer>> res, List<Integer> cur, int k, int pos, int n){
        if(cur.size() == k){
            res.add(new ArrayList<>(cur));
            return;
        }
        for(int i = pos; i <= n; i++){
            cur.add(i);
            DFS(res, cur, k, i + 1, n);
            cur.remove(cur.size() - 1);
        }
    }
}