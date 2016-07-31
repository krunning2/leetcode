public class Solution {
    public int reverse(int x) {
        if(x == Integer.MAX_VALUE) return 0;
        int sign = 1;
        if(x<0){
            sign *=-1;
        }
        int abs = Math.abs(x);
        long res = 0;
        while(abs>0){
            res = res*10+abs%10;
            abs /=10;
            if(res > Integer.MAX_VALUE || res<Integer.MIN_VALUE)
			return 0;
        }
        return res*sign;
    }
}