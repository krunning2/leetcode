public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> res = new ArrayList<String>();
        helper(s, wordDict, 0, res, "", new boolean[s.length()]);
        return res;
    }
    private void helper(String s, Set<String> dict, int pos, List<String> res, String cur, boolean[] visited){
        if(pos == s.length()) {
            res.add(cur);
        }
        for(int i = pos; i < s.length(); i++){
            if(!visited[i] && dict.contains(s.substring(pos, i + 1))){
                String tmp = pos == 0 ? s.substring(pos, i + 1) : cur + " "+ s.substring(pos, i + 1);
                int size = res.size();
                helper(s, dict, i+1, res, tmp, visited);
                if(size == res.size()) visited[i] = false;
            }
        }
    }
}