public class Solution {
    public boolean isNumber(String s) {
        if(s == null || s.length() == 0) return false;
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