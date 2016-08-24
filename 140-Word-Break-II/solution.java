public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> res = new ArrayList<String> ();
        DFS(s, 0, wordDict, new StringBuilder(), res, new int[s.length() + 1]);
        return res;
    }
    private boolean DFS(String s, int pos, Set<String> wordDict, StringBuilder sb, List<String> res, int[] mem){
        if(pos == s.length()){
            res.add(sb.substring(0, sb.length() - 1).toString());
            return true;
        }
        if(mem[pos] != 0 && mem[pos] != 1) return false;
        boolean flag = false;
        for(int i = pos; i < s.length(); i++){
            String sub = s.substring(pos, i + 1);
            if(wordDict.contains(sub)){
                int size = sb.length();
                sb.append(sub).append(" ");
                if(DFS(s, i + 1, wordDict, sb, res, mem)){
                    mem[pos] = 1;
                    flag = true;
                }
                sb.setLength(size);
            }
        }
        mem[pos] = flag ? 1 : -1;
        return flag;
    }
}