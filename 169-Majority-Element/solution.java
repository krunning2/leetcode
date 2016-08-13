public class Solution {
    public int majorityElement(int[] nums) {
        int res = -1;
        int count = 0;
        for(int n : nums){
            if(res == n){
                count ++;
            }else if(count == 0){
                res = n;
            }else{
                count--;
            }
        }
        return res;
    }
}