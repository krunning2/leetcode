public class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String[] parts = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = parts.length - 1; i >= 0; i--){
            String part = parts[i];
            if(!"".equals(part)){
                sb.append(part);
                if(i != 0) sb.append(" ");
            }
        }
        return sb.toString();
    }
}