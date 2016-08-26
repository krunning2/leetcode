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
}