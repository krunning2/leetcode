public class Solution {
    public boolean isMatch(String s, String p) {
        return helper(s, p, 0, 0, new int[s.length() + 1][p.length() + 1]);
    }
    private boolean helper(String s, String p, int ps, int pp, int[][] mem){
        if(pp == p.length()){
            return ps == s.length();
        }
        if(mem[ps][pp] != 0){
            return mem[ps][pp] == 1;
        }
        if(pp < p.length() - 1 && p.charAt(pp + 1) == '*'){
            while(pp < p.length() && ps < s.length() && (p.charAt(pp) == s.charAt(ps) || p.charAt(pp) == '.')){
                if(helper(s, p, ps, pp + 2, mem)){
                    mem[ps][pp] = 1;
                    return true;
                }
                ps++;
            }
            return helper(s, p, ps, pp + 2, mem);
        }else if(pp < p.length() && ps < s.length() && (p.charAt(pp) == s.charAt(ps) || p.charAt(pp) == '.')){
            return helper(s, p, ps + 1, pp + 1, mem);
        }
        mem[ps][pp] = -1;
        return false;
    }
}