public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if(n <= 0){
            return res;
        }
        DFS(n, n, res, new StringBuilder());
        return res;
    }
    private void DFS(int left, int right, List<String> res, StringBuilder sb){
        if(left == 0 && right == 0){
            res.add(sb.toString());
            return ;
        }
        if(left > 0){
            int len = sb.length();
            sb.append("(");
            DFS(left - 1, right, res, sb);
            sb.setLength(len);
        }
        if(right > left){
            int len = sb.length();
            sb.append(")");
            DFS(left, right - 1, res, sb);
            sb.setLength(len);
        }
    }
}