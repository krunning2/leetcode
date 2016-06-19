public class Solution {
    public double myPow(double x, int m) {
        long n = m;
        if(n < 0){
            n = -n;
            x = 1 / x;
        }
        double res = 1;
        for(double f = x; n > 0; n = n >> 1){
            if((n & 1) == 1){
                res *= f;
            }
            f *= f;
        }
        return res;
    }
}