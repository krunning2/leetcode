public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> res = new ArrayList<String> ();
        DFS(s, 0, wordDict, new StringBuilder(), res);
        return res;
    }
    private void DFS(String s, int pos, Set<String> wordDict, StringBuilder sb, List<String> res){
        if(pos == s.length()){
            res.add(sb.substring(0, sb.length() - 1).toString());
            return;
        }
        for(int i = pos; i < s.length(); i++){
            String sub = s.substring(pos, i + 1);
            if(wordDict.contains(sub)){
                int size = sb.length();
                sb.append(sub).append(" ");
                DFS(s, i + 1, wordDict, sb, res);
                sb.setLength(size);
            }
        }
    }
}