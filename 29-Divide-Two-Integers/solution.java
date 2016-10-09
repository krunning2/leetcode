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
        long s = 0, e = div;
        while(s + 1 < e){
            long mid = s - (s - e) / 2;
            if(mid * dis > div){
                e = mid;
            }else{
                s = mid;
            }
        }
        if(e * dis <= div) return (int) e * sign;
        if(s * dis <= div) return (int) s * sign;
        return Integer.MAX_VALUE;
    }
}