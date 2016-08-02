public class Solution {
    public int addDigits(int num) {
        while(num >= 10){
            int tmp = num;
            int res = 0;
            while(tmp > 0){
                res += tmp % 10;
                tmp /= 10;
            }
            num = res;
        }
        return num;
    }
}