public class Solution {
    public String reverseWords(String s) {
        if(s == null || s.length() == 0){
            return s;
        }
        String[] splits = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String s : splits){
            if(!s.equals(""))
                sb.append(s).append(" ");
        }
        return sb.toString();
    }
}