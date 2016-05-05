public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> rst = new ArrayList<String>();
        if(num == null || num.length() == 0) return rst;
        helper(rst, "", num, target, 0, 0, 0);
        return rst;
    }
    private void helper(String num, int target, List<String> res, String path, int pos, long eval, long multi){
        if(pos == num.length()){
            if(target == eval){
                res.add(path);
            }
            return;
        }
        for(int i = pos; i < num.length(); i++){
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