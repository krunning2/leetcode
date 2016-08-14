public class Solution {
    public String reverseString(String s) {
        if(s == null || s.length() == 0) return s;
        char chars[] = s.toCharArray();
        int s = 0;
        int e = s.length();
        while(s < e){
            char tmp = chars[s];
            chars[s] = chars[e];
            chars[e] = tmp;
        }
        return new String(chars);
    }
}