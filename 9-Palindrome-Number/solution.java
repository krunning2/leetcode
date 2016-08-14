public class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        long res = 0;
        int y = x;
        while(x > 0){
            res = res * 10 + x % 10;
            x /= 10;
        }
        if(res > Integer.MAX_VALUE) return false;
        return y == ((int)res);
    }
}