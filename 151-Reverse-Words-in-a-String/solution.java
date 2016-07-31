public class Solution {
    public String reverseWords(String s) {
        if(s == null || s.length() == 0){
            return s;
        }
        String[] splits = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = splits.length - 1; i >= 0; i--){
            String ss = splits[i];
            if(!ss.equals(""))
                sb.append(ss).append(" ");
        }
        return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1).toString(); 
    }
}