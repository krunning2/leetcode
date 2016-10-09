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
            long tmp = dis;
            while(div >= tmp){
                shift++;
                tmp <<= 1 ;
            }
            tmp >>= 1;
            shift --;
            res += 1 << shift;
            div -= tmp;
        }
        return res * sign;
    }
}