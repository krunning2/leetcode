public class Solution {
    public int mySqrt(int x) {
        // write your code here
        if(x == 0 || x == 1) return x;
        int end = x / 2;
        int start = 1;
        
        while(start + 1 < end){
            int mid = start - (start - end) / 2;
            if(mid < x / mid){
                start = mid;
            }else if(mid > x / mid){
                end = mid;
            }else{
                return mid;
            }
        }
        if(end  <= x / end){
            return end;
        }else{
            return start;
        }
    }
}