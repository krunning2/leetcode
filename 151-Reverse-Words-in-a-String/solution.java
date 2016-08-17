public class Solution {
    public String reverseWords(String s) {
        String[] parts = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = parts.length - 1; i >= 0; i--){
            String s = parts[i];
            if(! "".equals(s)){
                sb.append(s).append(" ");;
            }
        }
        return sb.toString().trim();
    }
}