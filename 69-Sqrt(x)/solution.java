public class Solution {
    public int mySqrt(int num) {
        if(num == 0 || num == 1) return num;
        int left = 1, right = num / 2;
        
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            long t = mid * mid;
            if (t > num) {
              right = mid;
            } else if (t < num) {
              left = mid;
            } else {
              return mid;
            }
        }
        if(left * left == num) return left;
        if(right * right == num) return right;
        if(right * right < num) return right;
        if(left * left < num) return left;
    }
}