public class Solution {
    public boolean isPerfectSquare(int num) {
        int num2 = num;
        for(int i = 1; i <= num2; i=i+2){
            num -= i;
            if(num == 0){
                return true;
            }else if(num < 0){
                return false;
            }
        }
        return false;
    }
}