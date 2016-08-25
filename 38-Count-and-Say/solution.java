public class Solution {
    public String countAndSay(int n) {
        String res = "1";
        if(n <= 0){
            return "0";
        }
        for(int i = 1; i < n; i++){
            res = helper(res);
        }
        return res;
    }
    private String helper(String s){
        int p0 = 0, p1 = 0;
        StringBuilder sb = new StringBuilder();
        while(p0 < s.length()){
            if(p0 < s.length() - 1 && s.charAt(p0) == s.charAt(p0 + 1)){
                int count = 0;
                char cur = s.charAt(p0);
                while(p0 < s.length() && s.charAt(p0) == cur){
                    p0++;
                    count++;
                }
                sb.append(count).append(cur);
            }else{
                sb.append(1).append(s.charAt(p0));
                p0++;
            }
        }
        return sb.toString();
    }
}