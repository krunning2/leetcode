public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList();
        res.add(0);
        if(n == 0) return res;
        for(int i = 1; i <= n; i++){
            int size = res.size();
            int x = 1 << (i - 1);
            for(int j = size - 1; j >= 0; j--){
                res.add(res.get(j) + x);
            }
        }
        return res;
    }
}