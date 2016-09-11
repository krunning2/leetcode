public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }
        String first = strs[0];
        int p = 0;
        while(p < first.length()){
            char cur = first.charAt(p);
            for(int i = 1; i < strs.length; i++){
                if(p >= strs[i].length() || cur != strs[i].charAt(p)){
                    return first.substring(0, p);
                }
            }
            p++;
        }
        return first;
    }
}