public class Solution {
    public double myPow(double x, int n) {
       return helper(x, n);
    }
    private double helper(double x, long n){
        if(n == 0) return 1.0;
        if(n < 0){
           x = 1/x;
           n = -n;
        }
        return n % 2 == 0 ? helper(x * x, n / 2) : x * helper(x * x, n / 2);
    }
}