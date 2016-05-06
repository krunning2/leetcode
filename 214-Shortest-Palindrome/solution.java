public class Solution {
    public String shortestPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = s.length() - 1; i >= 0; i--){
            if(isValid(s, 0, i)){
                sb.append(s.substring(i + 1)).reverse().append(s);
            }
        }
        return sb.toString();
    }
    private boolean isValid(String s, int start, int end){
        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
                start++;
                end--;
            }
        }
        return true;
    }
}