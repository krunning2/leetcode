public class Solution {
    public String reverseString(String s) {
        if(s == null || s.length() <= 1) return s;
        char[] chars = s.toCharArray();
        int start = 0, end = chars.length - 1;
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