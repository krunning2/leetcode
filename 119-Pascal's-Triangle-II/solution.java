public class Solution {
    public List<Integer> getRow(int k) {
        List<Integer> res = new ArrayList<Integer>();
        if(k < 0) return res;
        if(k == 0){
            res.add(1);
            return res;
        }
        int[] res = new int[k + 1];
        res[0] = 1;
        for(int i = 1; i <= k; i++){
            for(int j = i; j >= 0; j--){
                if(j == 0 || j == i){
                    res[j] = 1;
                }else{
                    res[j] = res[j] + res[j - 1];
                }
            }
        }
        return Arrays.asList(res);
    }
}