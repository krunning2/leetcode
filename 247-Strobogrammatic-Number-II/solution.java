public class Solution {
    public List<String> findStrobogrammatic(int n) {
        return helper(n, n);
    }
    private List<String> helper(int n, int m){
        if(m == 1){
            return new ArrayList<String>(Arrays.asList("0", "1", "8"));
        }
        if(m == 0){
            return new ArrayList<String>(Arrays.asList(""));
        }
        List<String> list = helper(n, m - 2);
        List<String> res = new ArrayList<String>();
        for(int i = 0; i < list.size(); i++){
             String s = list.get(i);
             if(m != n){
                 res.add("0" + s + "0");
             }
             res.add("1" + s + "1");
             res.add("6" + s + "9");
             res.add("8" + s + "8");
             res.add("9" + s + "6");
        }
        return res;
    }
}