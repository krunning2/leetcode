public class Solution {
    public List<String> findStrobogrammatic(int n) {
        List<String> res = new ArrayList<String> ();
        String[] digits = {"0", "1", "6", "8", "9"};
        DFS(res, n / 2, digits, 0, "");
        if(n % 2 == 0){
            for(int i = 0; i < res.size(); i++){
                res.set(fill(res.get(i), true, '0'));
            }
            return res;
        }else{
            char[] tmp = {'0', '1', '8'};
            List<String> newRes = new ArrayList<String> ();
            for(char c : tmp)
                for(int i= 0; i < res.size(); i++){
                    newRes.add(fill(res.get(i), false, c));
                }
            return newRes;
        }
    }
    private void DFS(List<String> res, int n, String[] digits, int pos, String cur){
        if(pos == n){
            res.add(cur);
            return;
        }
        for(int i = 0; i < digits.length; i++){
            DFS(res, n, digits, pos + 1, cur + digits[i]);
        }
    }
    private String fill(String s, boolean is_oven, char c){
        StringBuilder sb = new StringBuilder(s);
        int len = sb.length();
        if(!is_oven){
            sb.append(c);
        }
        for(int i = len - 1; i >= 0; i--){
            sb.append(getMirror(s.charAt(i)));
        }
        return sb.toString();
    }
    private char getMirror(char c){
        switch(c){
            case '0' : return '0';
            case '1' : return '1';
            case '6' : return '9';
            case '8' : return '8';
            case '9' : return '6';
        }
    }
}