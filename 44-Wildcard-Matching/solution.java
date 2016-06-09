public class Solution {
    public boolean isMatch(String s, String p) {
        if(s == null || p == null) return p == null && s == null;
        return helper(s, p, 0, 0, new int[s.length() + 1][p.length() + 1]);
    }
    
    private boolean helper(String s, String p, int ps, int pp, int[][] mem){
        if(pp == p.length()) return ps == s.length();
        if(mem[ps][pp] != 0) return mem[ps][pp] == 1;
        if(pp < p.length() && p.charAt(pp) == '*'){
            while(ps < s.length() && pp < p.length()){
                if(helper(s, p, ps, pp + 1, mem)){
                    mem[ps][pp] = 1;
                    return true;
                }
                ps ++;
            }
            return helper(s, p, ps, pp + 1, mem);
        }else if(ps < s.length() && pp < p.length() && (p.charAt(pp) == '?' || p.charAt(pp) == s.charAt(ps))){
            return helper(s, p, ps + 1, pp + 1, mem);
        }
        mem[ps][pp] = -1;
        return false;
    }
}