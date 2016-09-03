public class Solution {
    public String shortestPalindrome(String s) {
        if(s == null || s.length() <= 1) return s;
        StringBuilder sb = new StringBuilder(s);
        StringBuilder sb_rev = new StringBuilder(s).reverse();
        sb.append("#");
        sb.append(sb_rev);
        int index = getNext(sb);
        return sb_rev.substring(0, sb_rev.length() - index - 1) + s;
    }
    private int getNext(StringBuilder s){
        int i = 0;
        int j = -1;
        int[] next = new int[s.length()];
        next[0] = -1;
        while(i < s.length() - 1){
            if(j == -1 || s.charAt(i) == s.charAt(j)){
                j++;
                i++;
                next[i] = j;
            }else{
                j = next[j];
            }
        }
        return next[s.length() - 1];
    }
}