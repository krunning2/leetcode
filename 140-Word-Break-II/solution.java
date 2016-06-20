public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> res = new ArrayList<String>();
        helper(s, wordDict, 0, res, "");
        return res;
    }
    private void helper(String s, Set<String> dict, int pos, List<String> res, String cur){
        if(pos == s.length()) {
            res.add(cur);
        }
        for(int i = pos; i < s.length(); i++){
            if(dict.contains(s.substring(pos, i + 1))){
                String tmp = pos == 0 ? s.substring(pos, i + 1) : cur + " "+ s.substring(pos, i + 1);
                helper(s, dict, i+1, res, tmp);
            }
        }
    }
}