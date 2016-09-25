public class Solution {
    public boolean isPerfectSquare(int num) {
        if(num <= 0) return false;
        long start = 1, end = num / 2 + 1;
        while(start + 1 < end){
            long mid = start - (start - end) / 2;
            if(mid * mid == num){
                return true;
            }else if(mid * mid > num){
                end = mid;
            }else{
                start = mid;
            }
        }
        return start * start == num || end * end == num;
    }
}