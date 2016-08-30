public class Solution {
    public boolean isStrobogrammatic(String num) {
        if(num == null) return false;
        int start = 0;
        int end = num.length() - 1;
        while(start <= end){
            if(validate(num.charAt(start), num.charAt(end))){
                start ++;
                end --;
            }else{
                return false;
            }
        }
        return true;
    }
    private boolean validate(char c1, char c2){
        switch(c1){
            case '6' : return c2 == '9';
            case '8' : return c2 == '8';
            case '1' : return c2 == '1';
            case '0' : return c2 == '0';
            case '9' : return c2 == '6';
            default : return false;
        }
    }
}