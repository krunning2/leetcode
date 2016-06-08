public class Solution {
    public boolean isMatch(String s, String p) {
        if(s == null || p == null) return p == null && s == null;
        return helper(s, 0, p, 0, new int[s.length() + 1][p.length() + 1]);
    }
    private boolean helper(String s, int ps, Stirng p, int pp, int[][] mem){
        if(p1 == s.length()){
            return p2 == p.length();
        }
        if(mem[ps][pp] != 0) return mem[ps][pp] == 1;
        //
        if(pp < p.length() - 1 && p.charAt(pp + 1) == '*'){
            while(pp < p.length() && ps < ps.length() && (p.charAt(pp) == s.charAt(ps) || p.charAt(pp) == '.')){
                if(helper(s, ps, p, pp + 2, mem)){
                    mem[ps][pp] = 1;
                    return true;
                }
                ps++;
            }
            return helper(s, ps, p, pp + 2, mem);
        }else if(pp < p.length() && ps < s.length() && (p.charAt(pp) == s.charAt(ps) || p.charAt(pp) == '.')){
            return helper(s, ps + 1, p, pp + 1, mem);
        }
        return false;
    }
}