public class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 0;
        int i = digits.length - 1;
        for(; i >= 0; i--){
            if(digits[i] != 9){
                break;
            }else{
                digits[i] = 0;
            }
        }
        
        if(i == -1){
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            return res;
        }else{
            digits[i]++;
            return digits;
        }
    }
}