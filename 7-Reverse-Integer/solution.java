public class Solution {
    public int reverse(int x) {
        int sign = x < 0 ? -1 : 1;
        long abs = Math.abs(x);
        long res = 0;
        while(abs > 0){
            res = 10 * res + abs % 10;
            abs /= 10;
            if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) return 0;
        }
        return (int) (res * sign);
    }
}