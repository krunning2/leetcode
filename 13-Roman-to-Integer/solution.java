public class Solution {
    public int romanToInt(String s) {
        if(s == null || s.length() == 0) return 0;
        int res = 0;
        for(int i = 0; i < s.length(); i++){
            res += getInt(s.charAt(i));
            if(i > 0 && getInt(s.charAt(i)) > getInt(s.charAt(i - 1))){
                res -= 2 * getInt(s.charAt(i - 1));
            }
        }
        return res;
    }
    private int getInt(char c){
        switch(c){
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;
            default: return 0;
        }
    }
}