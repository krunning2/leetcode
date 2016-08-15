public class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int p = s.length() - 1;
        while(p >= 0){
            if(s.charAt(p) == ' '){
                break;
            }
            p--;
        }
        return s.length() - p - 1;
    }
}