public class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor == 0) return Integer.MAX_VALUE;
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (dividend == Integer.MIN_VALUE && divisor == 1) {
            return Integer.MIN_VALUE;
        }
        int sign = 1;
        if(dividend < 0) sign *= -1;
        if(divisor < 0) sign *= -1;
        long l_dividend = Math.abs((long) dividend);
        long l_divisor = Math.abs((long) divisor);
        long s = 0, e = l_dividend;
        while(s + 1 < e){
            long m = s - (s - e) / 2;
            if(m * l_divisor == dividend){
                return (int) m *  sign;
            }else if(m * l_divisor > l_dividend){
                e = m;
            }else{
                s = m;
            }
        }
        if(e * l_divisor <= l_dividend) return (int)(sign * e);
        return (int)(sign * s);
    }
}