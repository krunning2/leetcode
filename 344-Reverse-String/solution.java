public class Solution {
    public String reverseString(String s) {
        if(s == null || s.length() == 0) return s;
        char chars[] = s.toCharArray();
        int start = 0;
        int end = s.length();
        while(start < end){
            char tmp = chars[start];
            chars[start] = chars[end];
            chars[end] = tmp;
            start++;
            end--;
        }
        return new String(chars);
    }
}