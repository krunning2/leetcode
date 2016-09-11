public class Solution {
    public int reverse(int x) {
        int sign = x < 0 ? -1 : 1;
        long y = Math.abs((long)x);
        long res = 0;
        while(y > 0){
            res = res * 10 + y % 10;
            y /= 10;
        }
        res = res * sign;
        if(res > Integer.MAX_VALUE){
            return 0;
        }
        if(res < Integer.MIN_VALUE){
            return 0;
        }
        return (int)res;
    }
}