public class Solution {
    public int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0) return 0;
        int len = s.length() - 1;
        while(len >= 0 && s.charAt(len) == ' '){
            len--;
        }
        int lastWordLen = 0;
        while(len >= 0 && s.charAt(len) != ' '){
            len --;
            lastWordLen ++;
        }
        return lastWordLen;
    }
}