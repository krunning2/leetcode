public class Solution {
    public int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0) return 0;
        int len = 0;
        s = s.trim();
        int p = s.length() - 1;
        while(p >= 0){
            if(s.charAt(p) == ' '){
                return len;
            }else{
                len++;
            }
            p--;
        }
        if(p == -1) return s.length();
        return len;
    }
}