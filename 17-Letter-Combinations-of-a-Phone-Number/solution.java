public class Solution {
    public List<String> letterCombinations(String digits) {
        String[] dict = {"","", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> res = new ArrayList<String> ();
        DFS(dict, new StringBuilder(), digits, 0, res);
        return res;
    }
    private void DFS(String[] dict, StringBuilder sb, String digits, int pos, List<String> res){
        if(pos == sb.length()){
            res.add(sb.toString());
            return;
        }
        String chars = dict[pos];
        for(int i = 0; i < chars.length; i++){
            int len = sb.length();
            sb.append(chars.charAt(i));
            DFS(dict, sb, digits, pos + 1, res);
            sb.setLength(len);
        }
    }
}