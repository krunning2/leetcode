public class Solution {
    public int titleToNumber(String s) {
        int res = 0;
        if(s == null || s.length() == 0) return 0;
        int p = 0;
        while(p < s.length()){
            int cur = s.charAt(p) - 'A' + 1;
            res = res * 26 + cur;
        }
        return res;
    }
}