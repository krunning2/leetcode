public class Solution {
    public int myAtoi(String str) {
        if(str == null || str.length() == 0){
            //throw new Exception("invalid input");
            return 0;
        }
        str = str.trim();
        int p = 0;
        int sign = 1;
        if(str.charAt(0) == '+'){
            sign = 1;
            p++;
        }else if(str.charAt(0) == '-'){
            sign = -1;
            p++;
        }
        long res = 0;
        while(p < str.length()){
            if(isValid(str.charAt(p))){
                res = res * 10 + (str.charAt(p) - '0');
                p++;
                if(res * sign > Integer.MAX_VALUE){
                    //throw new Exception("invalid input"); 
                    return Integer.MAX_VALUE;
                }else if( res * sign < Integer.MIN_VALUE){
                    return Integer.MIN_VALUE;
                }
            }else{
               //throw new Exception("invalid input"); 
               break;
            }
        }
        
        return (int) (res * sign);
    }
    private boolean isValid(char c){
        return c <= '9' && c >= '0';
    }
}