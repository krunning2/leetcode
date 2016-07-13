public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if(s == null && t != null) return t.length() == 1;
        if(t == null && s != null) return s.length() == 1;
        if(s.length() == t.length()){
            return isModified(s, t);
        }else if(s.length() - t.length() == 1){
            return isDeleted(s, t);
        }else if(t.length() - s.length() == 1){
            return isDeleted(t, s);
        }else{
            return false;
        }
    }
    private boolean isModified(String t, String s){
        boolean flag = false;
        for(int i = 0; i < t.length(); i++){
            if(t.charAt(i) != s.charAt(i)){
                if(flag) return false;
                flag = true;
            }
        }
        return flag;
    }
    private boolean isDeleted(String longer, String shorter){
        for(int i = 0; i < shorter.length(); i++){
            if(longer.charAt(i) != shorter.charAt(i)){
                return longer.substring(i + 1).equals(shorter.substring(i));
            }
        }
        return true;
    }
}