public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<String>();
        helper(num, target, 0, "", 0, 0, res);
        return res;
    }
    private void helper(String num, int target, int pos, String s, long eval, long last, List<String> res){
        if(pos == num.length()){
            if(target == eval){
                res.add(s);
            }
            return;
        }
        for(int i = pos; i < num.length(); i++){
            String sub = num.substring(pos, i + 1);
            if(i != pos && sub.startsWith("0")) break;
            long val = Long.valueOf(sub);
            if(pos == 0){
                helper(num, target, i + 1, s + val, val, val, res);
            }else{
                helper(num, target, i + 1, s + "+" + val, eval + val, val, res);
                helper(num, target, i + 1, s + "-" + val, eval - val, -val, res);
                helper(num, target, i + 1, s + "*" + val, eval - last + last * val, last * val, res);
            }
        }
    }
}