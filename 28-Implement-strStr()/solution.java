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
        int j = 0, k = -1;
        next[0] = -1;
        while(j < p.length()){
            if(k == -1 || p.charAt(j) == p.charAt(k)){
                k++;
                j++;
                next[j] = k;
            }else{
                k = next[k];
            }
        }
        return next;
    }
}