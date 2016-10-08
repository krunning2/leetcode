public class Solution {
    public List<String> letterCombinations(String digits) {
        String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> res = new ArrayList<>();
        if(digits == null || digits.length() == 0) return res;
        DFS(0, digits, letters, new StringBuilder(), res);
        return res;
    }
    private void DFS(int pos, String digits, String[] letters, StringBuilder sb, List<String> res){
        if(sb.length() == digits.length()){
            res.add(sb.toString());
            return;
        }
        int num = digits.charAt(pos) - '0';
        for(int i = 0; i < letters[num].length(); i++){
            int len = sb.length();
            sb.append(letters[num].charAt(i));
            DFS(pos + 1, digits, letters, sb, res);
            sb.setLength(len);
        }
    }
}