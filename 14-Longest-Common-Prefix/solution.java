public class Solution {
    public String longestCommonPrefix(String[] strs) {
        int p = 0;
        if(strs == null || strs.length == 0) return "";
        if(strs.length == 1) return strs[0];
        String first = strs[0];
        while(p < first.length()){
            char cur = first.charAt(p);
            for(int i = 1; i < strs.length; i++){
                if(p >= strs[i].length() || strs[i].charAt(p) != cur){
                    return first.substring(0, p);
                }
            }
            p++;
        }
        return first;
    }
}