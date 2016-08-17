public class Solution {
    public String reverseWords(String s) {
        String[] parts = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = parts.length - 1; i >= 0; i--){
            String ss = parts[i];
            if(! "".equals(ss)){
                sb.append(ss).append(" ");;
            }
        }
        return sb.toString().trim();
    }
}