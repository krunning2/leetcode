public class Solution {
    public int trailingZeroes(int n) {
        int count = 0;
        for(int i = 5; i <= n; i+=5){
            int cur = i;
            while(cur % 5 == 0){
                count ++;
                cur /= 5;
            }
        }
        return count;
    }
}