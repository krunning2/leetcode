public class Solution {
    public int trailingZeroes(int n) {
        int count = 0;
        long fac = 5;
        while(n / fac >= 1){
            count += n / fac;
            fac *= 5;
        }
        return count;
    }
}