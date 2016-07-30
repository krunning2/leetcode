public class Solution {
    public boolean isPalindrome(String s) {
        s = s.trim().toLowerCase();
        int start = 0;
        int end = s.length() - 1;
        while(start <= end){
            if(check(s.charAt(start)) && check(s.charAt(end)) && s.charAt(start) != s.charAt(end)){
                return false;
            }
            if(!check(s.charAt(start))){
                start ++;
            }else if(!check(s.charAt(end))){
                end --;
            }else{
                start ++;
                end --;
            }
        }
        return true;
    }
    private boolean check(char c){
        return c <= 'z' && c >= 'a' || c >= '0'&& c <= '9';
    }
}