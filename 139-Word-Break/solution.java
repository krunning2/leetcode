public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        return helper(s, wordDict, 0);
    }
    private boolean helper(String s, Set<String> dict, int pos){
        if(pos == s.length()) return true;
        for(int i = pos; i < s.length(); i++){
            if(dict.contains(s.substring(pos, i + 1))){
                if(helper(s, dict, i+1)) return true;
            }
        }
        return false;
    }
}