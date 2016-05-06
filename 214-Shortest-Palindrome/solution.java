public class Solution {
    public String shortestPalindrome(String s) {
        boolean[][] mem =get(s);
        StringBuilder sb = new StringBuilder();
        for(int i = s.length() - 1; i >= 0; i--){
            if(mem[0][i]){
                sb.append(s.substring(i + 1)).reverse().append(s);
            }
        }
        return sb.toString();
    }
    private boolean[][] get(String s){
        int len = s.length();
        boolean[][] mem = new int[len][len];
        for(int i = 0; i < len; i++){
            mem[i][i] = true;
        }
        
        for(int l = 1; l < len; l ++){
            for(int start = 0; start + l < len; start++){
                if(s.charAt(start) == s.charAt(start + len) && (mem[start + 1][start + len - 1] || l == 1)){
                    mem[start][start + len] = true;
                }
            }
        }
        return mem;
    }
}