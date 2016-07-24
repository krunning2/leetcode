public class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        boolean numSeen = false;
        boolean eSeen = false;
        boolean dotSeen = false;
        boolean numAfterE = false;
        for(int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            if(cur >= '0' && cur <= '9'){
                numSeen = true;
                numAfterE = true;
            }else if(cur == '.'){
                if(eSeen || dotSeen) return false;
                dotSeen = true;
            }else if(cur == 'e'){
                if(eSeen || !numSeen) return false;
                eSeen = true;
                numAfterE = false;
            }else if(cur == '+' || cur == '-'){
                if(i != 0 && s.charAt(i - 1) != 'e') return false;
            }else {
                return false;
            }
        }
        return numSeen && numAfterE;
    }
}