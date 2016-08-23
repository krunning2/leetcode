public class Solution {
    public boolean isMatch(String s, String p) {
        int star1 = -1;
        int star2 = -1;
        int p1 = 0, p2 = 0;
        while(p1 <= s.length()){
            if(p1 >= s.length() && p2 >= p.length()){
                return true;
            }else if(p2 < p.length() && (p.charAt(p2) == s.charAt(p1) || p.charAt(p2) == '?')){
                p1++;
                p2++;
            }else if(p2 < p.length() && p.charAt(p2) == '*'){
                star1 = p1;
                p2 ++;
                star2 = p2;
            }else if(p2 >= p.length() || p.charAt(p2) != s.charAt(p1)){
                if(star1 == -1){
                    return false;
                }
                p2 = star2;
                p1 = star1;
                p1++;
                star2++;
                star1++;
            }
        }
        return false;
    }
}