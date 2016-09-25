public class Solution {
    public int mySqrt(int x) {
        int s = 0, e = x / 2 + 1;
        while(s + 1< e){
            int mid = s - (s - e) / 2;
            if(mid == x / mid) return mid;
            if(mid > x / mid){
                e = mid;
            }else{
                s = mid;
            }
        }
        return e <=x/e ? e : s; 
    }
    private double sqrt(double x){
        double start = 0, end = x / 2 + 1.0;
        double precision = 0.00000001;
        while(start + precision < end){
            double mid = (start + end) / 2;
            if(Math.abs(mid * mid - x) <= precision){
                return mid;
            }else if(mid * mid > x){
                end = mid;
            }else{
                start = mid;
            }
        }
        return Math.abs(start * start - x) < Math.abs(end * end - x) ? start : end;
    }
}