public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(numRows == 0) return res;
       
        
        res.add(new ArrayList<Integer>(){
            {
                add(1);
            }
        });
        if(numRows == 1){
            return res;
         }
        for(int i = 2; i <= numRows; i++){
            List<Integer> cur = new ArrayList<>();
            for(int j = 0; j < i; j++){
                if(j == 0 || j == i - 1){
                    cur.add(1);
                }else{
                    cur.add(res.get(i - 2).get(j) + res.get(i - 2).get(j - 1));
                }
            }
            res.add(cur);
        }
        return res;
    }
}