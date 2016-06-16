public class Solution {
    public boolean isStrobogrammatic(String num) {
        if(num == null || num.length() == 0){
            return true;
        }
        int start = 0, end = num.length() - 1;
        while(start < end){
            if(!check(num.charAt(start), num.charAt(end))){
                return false;
            }
            start++;
            end--;
        }
        if(start == end) return (num.charAt(start) == '6' || num.charAt(start) == '9' || num.charAt(start) == '1');
    }
    private boolean check(char c1, char c2){
        return (c1 == '6' && c2 == '9' || c1 == '9' && c2 == '6' || c1 == '1' && c2 == '1')
    }
}