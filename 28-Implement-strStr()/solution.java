public class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack == null || haystack.length() == 0 || needle == null || needle.length() == 0){
            return -1;
        }
        int[] = getNext(needle);
        int j = 0;
        for(int i = 0; i < haystack.length(); i++){
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
    }
    
    private int[] getNext(String s){
        int[] next = new int[s.length()];
        int j = 0;
        int k = -1;
        next[0] = -1;
        while(j < s.length()){
            if(k == -1 || s.charAt(j) == s.charAt(k)){
                j ++;
                k++;
                if(s.charAt(k) == s.charAt(j)){
                    next[j] = next[k];
                }else{
                    next[j] = k;
                }
            }else{
                k = next[k];
            }
        }
        return next;
    }
}