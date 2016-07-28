public class Solution {
    public boolean isPerfectSquare(int num) {
        int s = 1;
        int e = num / 2;
        while(s <= e){
            int mid = s - (s - e) / 2;
            int t = mid * mid;
            if(t == num){
                return true;
            }else if(t < num){
                s = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return false;
    }
}