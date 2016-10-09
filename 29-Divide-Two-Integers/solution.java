public class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor == 0 || dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        int sign = 1;
        if(dividend < 0) sign *= -1;
        if(divisor < 0) sign *= -1;
        long div = Math.abs((long) dividend);
        long dis = Math.abs((long) divisor);
        int res = 0;
        while(div >= dis){
            int shift = 0;
            while(div >= (dis << shift)){
                shift++;
            }
            shift --;
            res += 1 << shift;
            div -= dis << shift;
        }
        return res * sign;
    }
}