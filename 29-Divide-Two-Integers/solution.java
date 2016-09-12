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
        int res = 0;
        while(did >= dis){
            int shift = 0;
            while(did >= (dis << shift) ){
                shift ++;
            }
            shift --;
            res += 1 << shift;
            did -= dis << shift;
        }
        return sign * res;
    }
}