public class Solution {
    public int strStr(String haystack, String needle) {
        if((haystack == null || haystack.length() == 0) && needle != null && needle.length() != 0) return -1;
        if(needle == null || needle.length() == 0) return 0;
        int len1 = haystack.length();
        int len2 = needle.length();
        for(int i = 0; i <= len1 - len2 ; i++){
            int j = 0;
            while(j < len2){
                if(haystack.charAt(i + j) != needle.charAt(j)){
                    break;
                }
                j++;
                if(j == len2) return i;
            }
        }
        return -1;
    }
}