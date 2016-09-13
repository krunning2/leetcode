public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        if(s == null || s.length() == 0) return res;
        DFS(0, 0, s, new StringBuilder(), res);
        return res;
    }
    
    private void DFS(int pos, int count, String s, StringBuilder sb, List<String> res){
        if(count > 4){
            return;
        }
        if(pos == s.length() && count == 4){
            sb.setLength(sb.length() - 1);
            res.add(sb.toString());
        }
        
        for(int i = pos; i < s.length(); i++){
            String sub = s.substring(pos, i + 1);
            if(isValid(sub)){
                int len = sb.length();
                DFS(i + 1, count + 1, s, sb.append(sub).append("."), res);
                sb.setLength(len);
            }
        }
    }
    
    private boolean isValid(String s){
        if(s.length() > 3 || s.length() <= 0){
            return false;
        }
        if(s.length() > 1 && s.startsWith("0")){
            return false;
        }
        int val = Integer.valueOf(s);
        if(val >= 0 && val <=255){
            return true;
        }
        return false;
    }
}