public class Solution {
    public int romanToInt(String s) {
        if(s == null || s.length() == 0) return 0;
        int res = 0;
        for(int i = 0; i < s.length(); i++){
            int cur = get(s.charAt(i));
            if(i > 0 && cur > get(s.charAt(i - 1))){
                cur -= 2 * get(s.charAt(i - 1));
            }
            res += cur;
        }
        return res;
    }
    private int get(char c){
        switch(c){
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;
        }
        return 0;
    }
}