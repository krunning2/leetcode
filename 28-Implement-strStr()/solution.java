public class Solution {
    public int strStr(String s, String p) {
        if(s == null && p != null || s.length() == 0 && p.length() != 0) return -1;
        if(p == null || p.length() == 0) return 0;
        int[] next = getNext(p);
        int i = 0, j = 0;
        while(i < s.length()){
            if(j== -1 || p.charAt(j) == s.charAt(i)){
                j++;
                i++;
                if(j == p.length()){
                    return i - j;
                }
            }else{
                j = next[j];
            }
        }
        return -1;
    }
    private int[] getNext(String p){
        int[] next = new int[p.length() + 1];
        int i = 0, j = -1;
        next[0] = -1;
        while(i < p.length()){
            if(j == -1 || p.charAt(i) == p.charAt(j)){
                j++;
                i++;
                next[i] = j;
            }else{
                j = next[j];
            }
        }
        return next;
    }
}