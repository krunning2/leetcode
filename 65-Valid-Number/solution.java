public class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        boolean seenNum = false;
        boolean seenDot = false;
        boolean seenE = false;
        boolean numAfterE = false;
        for(int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            if(cur <= '9' && cur >= '0'){
                seenNum = true;
                numAfterE = true;
            }else if(cur == 'e'){
                if(seenE || !seenNum){
                    return false;
                }
                seenE = true;
                numAfterE = false;
            }else if(cur == '.'){
                if(seenDot || seenE){
                    return false;
                }
                seenDot = true;
            }else if(cur == '+' || cur == '-'){
                if(i != 0 && s.charAt(i - 1) != 'e'){
                    return false;
                }
            }else{
                return false;
            }
        }
        return seenNum && numAfterE;
    }
}