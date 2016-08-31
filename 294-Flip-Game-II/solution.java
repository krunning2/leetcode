public class Solution {
    public boolean canWin(String s) {
        return helper(s.toCharArray());
    }
    private boolean helper(char[] chars){
        for(int i = 0; i < chars.length - 1; i++){
            if(chars[i] == '+' && chars[i + 1] == '+'){
                chars[i] = chars[i + 1] = '-';
                boolean flag = helper(chars);
                chars[i] = chars[i + 1] = '+';
                if(!flag) return true;
            }
        }
        return false;
    }
}