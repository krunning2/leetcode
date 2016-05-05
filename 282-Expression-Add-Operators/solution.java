public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<String>();
        if(num == null || num.length() == 0) return res;
        helper(num, target, res, "", 0, 0, 0);
        return res;
    }
    private void helper(String num, int target, List<String> res, String path, int pos, long eval, long multi){
        if(pos == num.length()){
            if(target == eval){
                res.add(path);
            }
            return;
        }
        for(int i = pos; i < num.length(); i++){
            //if it starts with "0", this digit should only be 0, not 05,0005.....
            if(i != pos && num.charAt(pos) == '0') break;
            long cur = Long.parseLong(num.substring(pos, i + 1));
            if(pos == 0){
                helper(num, target, res, path + cur, i + 1, cur, cur);
            }else{
                helper(num, target, res, path + "+" +cur, i + 1, eval + cur, cur);
                helper(num, target, res, path + "-" +cur, i + 1, eval - cur, -cur);
                helper(num, target, res, path + "*" +cur, i + 1, eval - multi + cur * multi, cur * multi);
            }
        }
    }
}