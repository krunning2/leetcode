public class Solution {
    public boolean isMatch(String s, String p) {
        int p1 = 0, p2 = 0, s1 = 0, s2 = 0;
        boolean is_star = false;
        while(s1 < s.length()){
            if(p1 < p.length() && (s.charAt(s1) == p.charAt(p1) || p.charAt(p1) == '?')){
                s1 ++;
                p1 ++;
            }else if(p1 < p.length() && p.charAt(p1) == '*'){
                is_star = true;
                p2 = ++p1;
                s2 = s1;
               
            }else if(p1 == p.length() || p.charAt(p1) != s.charAt(s1)){
                if(!is_star) return false;
                s2++;
                p1 = p2;
                s1 = s2;
            }
        }
        while(p1 < p.length() && p.charAt(p1) == '*'){
            p1 ++;
        }
        return p1 == p.length();
    }
}