public class Solution {
    public double myPow(double x, int n) {
        long m = n;
        if(m < 0){
            m = -m;
            x = 1/x;
        }
        double res = 1;
        double f = x;
        for(; m > 0; m = m >> 1){
            if((m & 1) == 1){
                res *= f;
            }
            f *= f;
        }
        return res;
    }
}