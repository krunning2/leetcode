public class Solution {
    public boolean isNumber(String s) {
        if(s == null || s.length() == 0) return false;
        if(s.contains("e")) return valid(s);
        return validWithoutE(s);
    }
    
    private boolean validWithoutE(String s){
        s = s.trim();
        boolean seenNum = false;
        boolean seenDot = false;
        for(int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            if(cur >= '0' && cur <= '9'){
                seenNum = true;
            }else if(cur == '.'){
                if(seenDot) return false;
                seenDot = true;
            }else if(cur == '+' || cur == '-'){
                if(i != 0) return false;
            }else{
                return false;
            }
        }
        return seenNum;
    }
    
    private boolean valid(String s){
        
        s = s.trim();
        boolean seenNum = false;
        boolean seenE = false;
        boolean seenDot = false;
        boolean numAfterE = false;
        for(int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            if(cur >= '0' && cur <= '9'){
                seenNum = true;
                numAfterE = true;
            }else if(cur == 'e'){
                if(seenE || !seenNum) return false;
                numAfterE = false;
                seenE = true;
            }else if(cur == '.'){
                if(seenE || seenDot) return false;
                seenDot = true;
            }else if(cur == '+' || cur == '-'){
                if(i != 0 && s.charAt(i - 1) != 'e') return false;
            }else{
                return false;
            }
        }
        return seenNum && numAfterE;
    }
}