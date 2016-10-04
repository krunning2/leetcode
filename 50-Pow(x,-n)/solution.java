public class Solution {
    public double myPow(double x, int m) {
        long n = m;
        if(n < 0){
            x = 1 / x;
            n *= -1;
        }
        double fac = x;
        double res = 1.0;
        while(n > 0){
            if((n & 1) == 1){
                res *= fac;
            }
            n = n >> 1;
            fac *= fac;
        }
        return res;
    }
}