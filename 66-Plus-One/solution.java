public class Solution {
    public int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0){
            return new int[1]{1};
        }
        int n = digits.length;
        for(int i = 0; i < n; i++){
            if(digits[i] == 9){
                digits[i] = 0;
            }else{
                digits[i]++;
                return digits;
            }
        }
        int[] res = new int[n + 1];
        res[0] = 1;
        return res;
    }
}