public class Solution {
    public int mySqrt(int num) {
        if(num == 0 || num == 1) return num;
        int left = 1, right = num / 2;
        
        while (left + 1 < right) {
            int mid = left - (left - right) / 2;
            if (mid > num / mid) {
              right = mid;
            } else if (mid < num / mid) {
              left = mid;
            } else {
              return mid;
            }
        }
        if(right  <= num / right){
            return right;
        }else{
            return left;
        }
    }
}