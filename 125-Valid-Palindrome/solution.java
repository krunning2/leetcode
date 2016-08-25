public class Solution {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0) return true;
        s = s.trim().toLowerCase();
        int start = 0, end = s.length() - 1;
        while(start <= end){
            if(!isValid(s.charAt(start))){
                start++;
            }else if(!isValid(s.charAt(end))){
                end--;
            }else if(s.charAt(end) != s.charAt(start)){
                return false;
            }else{
                start++;
                end--;
            }
        }
        return true;
    }
    private boolean isValid(char c){
        if(c >= 'a' && c <= 'z' || c >= '0' && c <= '9') return true;
        return false;
    }
}