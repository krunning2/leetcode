public class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack == null || needle == null){
            return -1;
        }
        if(needle.length() == 0){
            return 0;
        }
        int[] next = getNext(needle);
        int j = 0;
        int i = 0;
        while(i < haystack.length()){
            if(j == -1 || haystack.charAt(i) == needle.charAt(j)){
                j ++;
                i++;
                if(j == needle.length()){
                    return i - j;
                }
            }else{
                j = next[j];
            }
        }
        return -1;
    }
    
    private int[] getNext(String s){
        int[] next = new int[s.length() + 1];
        int j = 0;
        int k = -1;
        next[0] = -1;
        while(j < s.length()){
            if(k == -1 || s.charAt(j) == s.charAt(k)){
                j ++;
                k++;
                next[j] = k;
            }else{
                k = next[k];
            }
        }
        return next;
    }
}