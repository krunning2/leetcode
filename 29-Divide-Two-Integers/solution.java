public class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor == 0) return Integer.MAX_VALUE;
        if(dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        int sign = 1;
        if(dividend < 0) sign *= -1;
        if(divisor < 0) sign *= -1;
        long dis = Math.abs((long)divisor);
        long did = Math.abs((long)dividend);
//        int res = 0;
        long start = 0;
        long end = did;
        while(start + 1 < end){
            long mid = start - (start - end) / 2;
            if(mid >= did / dis){
                end = mid;
            }else{
                start = mid;
            }
        }
        if(start == did / dis) return (int)(sign * start);
        if(end == did / dis) return (int)(sign * end);
        return 0;
    }
}