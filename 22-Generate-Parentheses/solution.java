public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        if(n <= 0){
            return res;
        }
        helper(n, 0, 0, res, new StringBuilder());
        return res;
    }
    
    private void helper(int n, int l, int r, List<String> res, StringBuilder sb){
        if(sb.length() == 2 * n){
            res.add(sb.toString());
            return;
        }
        int len = sb.length();
        if(l < n){
            sb.append("(");
            helper(n, l + 1, r, res, sb);
            sb.setLength(len);
        }
        if(r < l){
            sb.append(")");
            helper(n, l, r + 1, res, sb);
            sb.setLength(len);
        }
    }
}