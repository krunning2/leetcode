public class Solution {
    public boolean isPerfectSquare(int num) {
        long start = 1;
        long end = num / 2 + 1;
        while(start + 1 < end){
            long mid = start - (start - end) / 2;
            if(mid * mid == num){
                return true;
            }else if(mid * mid < num){
                start = mid;
            }else{
                end = mid;
            }
        }
        return start * start == num || end * end == num;
    }
}