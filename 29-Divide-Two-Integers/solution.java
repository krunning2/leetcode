public class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor == 0) return Integer.MAX_VALUE;
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        int sign = 1;
        if(dividend < 0) sign *= -1;
        if(divisor < 0) sign *= -1;
        long dvd = (long) Math.abs((long) dividend);
        long dis = (long) Math.abs((long) divisor);
        int res = 0;
        while(dis <= dvd){
            int shift = 0;
            while(dvd >= (dis << shift)) shift++;
            shift --;
            res += 1 << shift;
            dvd -= dis << shift;
        }
        return sign * res;
    }
}