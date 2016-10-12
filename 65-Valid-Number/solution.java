public class Solution {
    public boolean isNumber(String s) {
        if(s == null || s.length() == 0) return false;
        boolean seenDot = false;
        boolean seenE = false;
        boolean numAfterE = false;
        boolean seenNum = false;
        s = s.trim();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c >= '0' && c <= '9'){
                seenNum = true;
                numAfterE = true;
            }else if(c == '.'){
                if(seenDot || seenE) return false;
                seenDot = true;
            }else if(c == 'e'){
                if(seenE || !seenNum) return false;
                numAfterE = false;
                seenE = true;
            }else if(c == '+' || c == '-'){
                if(i != 0 && s.charAt(i - 1) != 'e') return false;
            }else{
                return false;
            }
        }
        return seenNum && numAfterE;
    }
}