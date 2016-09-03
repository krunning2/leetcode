public class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() <= 1) return s;
        int size = s.length();
        boolean[][] map = new boolean[size][size];
        for(int i = 0; i < size; i++){
            map[i][i] = true;
        }
        int max = 1;
        String res = "";
        // len 表示加上的长度，并非总长度
        for(int len = 1; len < size; len ++){
            for(int start = 0; start + len < size; start++){
                if(s.charAt(start) == s.charAt(start + len) && (map[start + 1][start + len - 1] || len == 1)){
                    map[start][start + len] = true;
                    if(max < len + 1){
                        max = len + 1;
                        res = s.substring(start, start + len + 1);
                    }
                }
            }
        }
        return res;
    }
}