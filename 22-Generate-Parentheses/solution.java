public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        helper(n, n, res, new StringBuilder());
        return res;
    }
    private void helper(int left, int right, List<String> res, StringBuilder sb){
        if(left == 0 && right == 0){
            res.add(sb.toString());
            return;
        }
        int len = sb.length();
        if(left > 0){
            sb.append("(");
            helper(left - 1, right, res, sb);
            sb.setLength(len);
        }
        if(left < right){
            sb.append(")");
            helper(left, right - 1, res, sb);
            sb.setLength(len);
        }
        
    }
}