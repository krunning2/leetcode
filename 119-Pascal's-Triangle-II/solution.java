public class Solution {
    public List<Integer> getRow(int k) {
        
        if(k < 0){
            List<Integer> res = new ArrayList<Integer>();
            return res;
        } 
        if(k == 0){
            List<Integer> res = new ArrayList<Integer>();
            res.add(1);
            return res;
        }
        Integer[] res = new int[k + 1];
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
        return new ArrayList<Integer>(Arrays.asList(res));
    }
}