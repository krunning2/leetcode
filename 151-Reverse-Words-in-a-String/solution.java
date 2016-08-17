public class Solution {
    public String reverseWords(String s) {
        String[] parts = s.split(" ");
        Arrays.reverse(parts);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < parts.length(); i++){
            String s = parts[i];
            if(! "".equals(s)){
                sb.append(s).append(" ");;
            }
        }
        return sb.toString().trim();
    }
}