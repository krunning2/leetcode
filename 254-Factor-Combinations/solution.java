public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(res, n, 2, new ArrayList());
        return res;
    }
    
    private void helper(List<List<Integer>> res, int n, int start, List<Integer> cur){
        if(n == 1){
            if(cur.size() > 1){
                res.add(new ArrayList(cur));
            }
            return;
        }
        for(int i = start; i <= n; i++){
            if(n % i == 0){
                cur.add(i);
                helper(res, n / i, i, cur);
                cur.remove(cur.size() - 1);
            }
        }
    }
}