public class Solution {
    public String countAndSay(int n) {
        if(n <= 0) return "";
        String res = "1";
        while(n > 1){
            res = count(res);
            n--;
        }
        return res;
    }
    private String count(String s){
        int p = 0;
        StringBuilder sb = new StringBuilder();
        while(p < s.length()){
            if(p < s.length() - 1 && s.charAt(p) == s.charAt(p + 1)){
                char cur = s.charAt(p);
                int count = 0;
                while(p < s.length() && cur == s.charAt(p)){
                    count ++;
                    p++;
                }
                sb.append(count).append(cur);
            }else{
                sb.append(1).append(s.charAt(p));
                p++;
            }
        }
        return sb.toString();
    }
}