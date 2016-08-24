public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if(s == null) return false;
        return DFS(s, 0, wordDict, new int[s.length() + 1]);
    }
    private boolean DFS(String s, int pos, Set<String> wordDict, int[] mem){
        if(pos == s.length()){
            return true;
        }
        if(mem[pos] != 0) return mem[pos] == 1;
        for(int i = pos; i < s.length(); i++){
            String sub = s.substring(pos, i + 1);
            if(wordDict.contains(sub)){
                if(DFS(s, i + 1, wordDict, mem)){
                    mem[pos] = 1;
                    return true;
                } 
            }
        }
        mem[pos] = -1;
        return false;
    }
}