public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> one = new ArrayList<Integer>();
        one.add(1);
        res.add(one);
        if(numRows == 1){
            return res;
        }
        ArrayList<Integer> two = new ArrayList<Integer>();
        two.add(1);
        two.add(1);
        res.add(two);
        if(numRows == 2){
            return res;
        }
        for(int i = 3; i <= 5; i++){
            List<Integer> cur = new ArrayList<Integer>();
            for(int j = 0; j < i; j++){
                if(j == 0 || j == i - 1){
                    cur.add(1);
                }else{
                    cur.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
                }
            }
            res.add(cur);
        }
        return res;
    }
}