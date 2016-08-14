public class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor == 0) return Integer.MAX_VALUE;
        int sign = 1;
        if(dividend < 0) sign *= -1;
        if(divisor < 0) sign *= -1;
        long l_dividend = Math.abs((long) dividend);
        long l_divisor = Math.abs((long) divisor);
        long s = 1, e = l_dividend;
        while(s + 1 < e){
            long m = s - (s - e) / 2;
            if(m * l_divisor == dividend){
                return m;
            }else if(m * l_divisor > dividend){
                e = m;
            }else{
                s = m;
            }
        }
        if(e * l_divisor < l_dividend) return sign * ((int) e);
        return sign * ((int) s);
    }
}