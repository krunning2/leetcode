public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>> ();
        if(n <= 1) return res;
        List<Integer> set = new ArrayList<Integer>();
        for(int i = 2; i < n / 2 + 1; i++){
            if(n % i == 0){
                set.add(i);
            }
        }
        DFS(set, 0, 1, n, res, new ArrayList<>());
        return res;
    }
    private void DFS(List<Integer> set, int start, long fac, int n, List<List<Integer>> res, List<Integer> list){
        if(fac > n){
            return;
        }
        if(fac == n){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = start; i < set.size(); i++){
            fac *= set.get(i);
            list.add(set.get(i));
            DFS(set, i, fac, n, res, list);
            list.remove(list.size() - 1);
            fac /= set.get(i);
        }
    }
}