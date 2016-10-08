public class Solution {
    public int titleToNumber(String s) {
        int result = 0;
        if(s == null || s.length() == 0) return result;
        for(int i = 0; i < s.length(); i++){
            result = result * 26 + (s.charAt(i) - 'A' + 1);
        }
        return result;
    }
}