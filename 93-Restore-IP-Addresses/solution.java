public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        if(s == null || s.length() == 0){
            return res;
        }
        helper(s, 0, 0, new StringBuilder(), res);
        return res;
    }
    
    private void helper(String s, int start, int pos, StringBuilder sb, List<String> res){
        if(pos > 4) return;
        
        if(start == s.length() && pos == 4){
            sb.setLength(sb.length() - 1);
            res.add(sb.toString());
            return;
        }
        
        for(int i = start; i < s.length(); i++){
            String cur = s.substring(start, i + 1);
            if(isValid(cur)){
                int size = sb.length();
                sb.append(cur).append(".");
                helper(s, i + 1, pos + 1, sb, res);
                sb.setLength(size);
            }
        }
    }
    
    private boolean isValid(String s){
        if(s.length() > 3 || s.length() <= 0){
            return false;
        }
        if(s.charAt(0) == '0' && s.length() > 1) return false;
        int v = Integer.valueOf(s);
        if(v > 255 || v < 0){
            return false;
        }
        return true;
    }
}