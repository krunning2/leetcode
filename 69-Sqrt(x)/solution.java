public class Solution {
    public int mySqrt(int num) {
        long left = 1, right = num / 2 + 1;// long type to avoid 2147483647 case
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long t = mid * mid;
            if (t > num) {
              right = mid - 1;
            } else if (t < num) {
              left = mid + 1;
            } else {
              return mid;
            }
        }
        return 0;
    }
}