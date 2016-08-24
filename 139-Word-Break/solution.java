public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if(s == null) return false;
        return DFS(s, 0, wordDict);
    }
    private boolean DFS(String s, int pos, Set<String> wordDict){
        if(pos == s.length()){
            return true;
        }
        for(int i = pos; i < s.length(); i++){
            String sub = s.substring(pos, i + 1);
            if(wordDict.contains(sub)){
                if(DFS(s, i + 1, wordDict)) return true;
            }
        }
        return false;
    }
}