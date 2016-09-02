public class Solution {
    public int myAtoi(String str) {
        if(str == null || str.length() == 0){
            return 0;
        }
        str = str.trim();
        int sign = 1;
        int start = 0;
        if(str.charAt(0) == '-'){
            start++;
            sign = -1;
        }else if(str.charAt(0) == '+'){
            start++;
        }
        long res = 0;
        for(int i = start; i < str.length(); i++){
            if(str.charAt(i) > '9' || str.charAt(i) < '0') return (int)res * sign;
            res = res * 10 + (str.charAt(i) - '0');
            if(sign == -1 && sign * res <= Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }else if(sign == 1 && res >= Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
        }
        return (int)res * sign;
    }
}