public class Solution {
    public int bulbSwitch(int n) {
        int count = 0;
        for(int i = 1; i <= n / 2 + 1; i++){
            if(i <= n / i){
                count++;
            }
        }
        return count;
    }
}