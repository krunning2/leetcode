public class Solution {
    public String shortestPalindrome(String s) {
        if(s == null || s.length() == 0){
            return "";
        }
        StringBuilder sb = new StringBuilder(s);
        StringBuilder sb_rev = new StringBuilder(s).reverse();
        sb.append("#");
        sb.append(sb_rev);
        int index = getNext(sb);
        return sb_rev.substring(0, sb_rev.length() - index - 1) + s;
    }
    private int getNext(StringBuilder sb){
        int[] next = new int[sb.length()];
        int j = 0, k = -1;
        next[0] = -1;
        while(j < sb.length() - 1){
            if(k == -1 || sb.charAt(j) == sb.charAt(k)){
                k ++;
                j ++;
                next[j] = k;
            }else{
                k = next[k];
            }
        }
        return next[sb.length() - 1];
    }
}