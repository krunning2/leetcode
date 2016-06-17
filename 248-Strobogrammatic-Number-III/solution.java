public class Solution {
    public int strobogrammaticInRange(String low, String high) {        
        List<String> res = new ArrayList<String>();
        for(int i = low.length(); i <= high.length(); i++){
            res.addAll(helper(i, i));
        }
        int count = 0;
        for(String s : res){
            if(s.length() == low.length() && s.compareTo(low) < 0 || s.length() == high.length() && s.compareTo(high) > 0){
                continue;    
            }
            count++;
        }
        return count;
    }
    private List<String> helper(int m, int n){
        if(m == 0){
            return new ArrayList<String>(Arrays.asList(""));
        }
        if(m == 1){
            return new ArrayList<String>(Arrays.asList("0", "1", "8"));
        }
        List<String> list = helper(m - 2, n);
        List<String> res = new ArrayList<String>();
        for(int i = 0; i < list.size(); ++){
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