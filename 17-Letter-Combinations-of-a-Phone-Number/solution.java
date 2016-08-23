public class Solution {
    public List<String> letterCombinations(String digits) {
        String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> res = new ArrayList<String>();
        if(digits == null || digits.length() == 0){
            return res;
        }
        DFS(digits, 0, new StringBuilder(), res, letters);
        return res;
    }
    private void DFS(String digits, int pos, StringBuilder sb, List<String> res, String[] letters){
        if(pos == digits.length()){
            res.add(sb.toString());
            return;
        }
        String s = letters[digits.charAt(pos) - '0'];
        for(int i = 0; i < s.length(); i++){
            int len = sb.length();
            sb.append(s.charAt(i));
            DFS(digits, pos + 1, sb, res, letters);
            sb.setLength(len);
        }
    }
}